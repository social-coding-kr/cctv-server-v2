package com.socialcoding.interfaces.api.internal.cctv.service;

import com.socialcoding.domain.cctv.model.Address;
import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.cctv.model.OfficialCctvInsertForm;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.domain.common.service.CsvService;
import com.socialcoding.domain.map.model.MapCluster;
import com.socialcoding.domain.map.service.MapClusterFacadeService;
import com.socialcoding.interfaces.api.internal.cctv.dto.OfficialCctvRegisterFileForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InternalCctvFacadeService {

	private final CctvFacadeService cctvFacadeService;

	private final CsvService csvService;

	private final MapClusterFacadeService mapClusterFacadeService;

	@Autowired
	public InternalCctvFacadeService(CctvFacadeService cctvFacadeService, CsvService csvService, MapClusterFacadeService mapClusterFacadeService) {
		this.cctvFacadeService = cctvFacadeService;
		this.csvService = csvService;
		this.mapClusterFacadeService = mapClusterFacadeService;
	}

	public void register(OfficialCctvRegisterFileForm registerForm) {

		Map<Long, Map<String, String>> official = csvService.read(Paths.get(registerForm.getOfficialCctvFilePath()).toFile(), line -> {
			Map<String, String> data = new HashMap<>();
			data.put("cctvId", filterNull(line[0]));
			data.put("cctvName", filterNull(line[1]));
			data.put("address", filterNull(line[2]));
			data.put("borough", filterNull(line[3]));
			data.put("dong", filterNull(line[4]));
			data.put("range", filterNull(line[5]));
			data.put("department", filterNull(line[6]));
			data.put("pixel", filterNull(line[7]));
			data.put("form", filterNull(line[8]));
			data.put("installedAt", Optional.ofNullable(filterNull(line[9])).filter(d -> !"\n".equalsIgnoreCase(d)).orElse(null));
			return data;
		}).stream()
			.collect(Collectors.toMap(map ->
				Long.parseLong(map.get("cctvId")), map -> map));

		Map<Long, Map<String, String>> common = csvService.read(Paths.get(registerForm.getCommonCctvFilePath()).toFile(), line -> {
			Map<String, String> data = new HashMap<>();
			data.put("cctvId", line[0]);
			data.put("latitude", line[1]);
			data.put("longitude", line[2]);
			data.put("purpose", filterNull(line[3]));
			data.put("source", line[4]);
			return data;
		}).stream()
			.collect(Collectors.toMap(map -> Long.parseLong(map.get("cctvId")), map -> map));


		log.debug("count: {}, {}", official.size(), common.size());

		Map<String, String> clusters = mapClusterFacadeService.listMapClusters().stream()
			.collect(Collectors.toMap(MapCluster::getClusterName, MapCluster::getClusterId));

		mergeById(official, common, clusters).forEach(cctvFacadeService::insert);
	}

	private String filterNull(String data) {
		return Optional.ofNullable(data).filter(str -> !"NULL".equalsIgnoreCase(str)).orElse(null);
	}

	private List<OfficialCctvInsertForm> mergeById(Map<Long, Map<String, String>> official, Map<Long, Map<String, String>> common,
		Map<String, String> clusters) {
		return official.entrySet().stream()
			.filter(entry -> common.containsKey(entry.getKey()))
			.map(entry -> {
				Map<String, String> officialElements = entry.getValue();
				Map<String, String> commonElements = common.get(entry.getKey());

				Map<String, String> merged = new HashMap<>(officialElements);
				merged.putAll(commonElements);
				return merged;
			})
			.map(map -> {
				try {
					OfficialCctvInsertForm insertForm = new OfficialCctvInsertForm();
					insertForm.setName(map.get("cctvName"));

					Address address = new Address(map.get("address"), "서울특별시", map.get("borough"), map.get("dong"));
					insertForm.setAddress(address);

					insertForm.setClusterId(clusters.get(map.get("borough")));

					DecimalFormat decimalFormat = new DecimalFormat();
					decimalFormat.setParseBigDecimal(true);
					Geolocation location = Geolocation.of(
						(BigDecimal) decimalFormat.parse(map.get("latitude")),
						(BigDecimal) decimalFormat.parse(map.get("longitude")));
					insertForm.setLocation(location);
					insertForm.setDataSource(map.get("source"));

					Map<String, String> extraProperties = new HashMap<>();
					Optional.ofNullable(map.get("range")).ifPresent(d -> extraProperties.put("range", d));
					Optional.ofNullable(map.get("department")).ifPresent(d -> extraProperties.put("department", d));
					Optional.ofNullable(map.get("pixel")).ifPresent(d -> extraProperties.put("pixel", d));
					Optional.ofNullable(map.get("form")).ifPresent(d -> extraProperties.put("form", d));
					Optional.ofNullable(map.get("installedAt")).ifPresent(d -> extraProperties.put("installed_at", d));
					Optional.ofNullable(map.get("purpose")).ifPresent(d -> extraProperties.put("purpose", d));
					insertForm.setExtraProperties(extraProperties);

					return insertForm;
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			})
			.collect(Collectors.toList());
	}

}
