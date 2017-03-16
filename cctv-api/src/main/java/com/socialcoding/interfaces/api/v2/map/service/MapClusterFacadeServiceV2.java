package com.socialcoding.interfaces.api.v2.map.service;

import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvSearchConditions;
import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.domain.common.service.CsvService;
import com.socialcoding.domain.map.model.MapCluster;
import com.socialcoding.domain.map.model.MapClusterInsertForm;
import com.socialcoding.domain.map.service.MapClusterFacadeService;
import com.socialcoding.interfaces.api.v2.map.dto.MapBoundSearchForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusterRegisterFileForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusterRegisterForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusteredCctvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MapClusterFacadeServiceV2 {

	private final MapClusterFacadeService mapClusterFacadeService;

	private final CctvFacadeService cctvFacadeService;

	private final CsvService csvService;

	@Autowired
	public MapClusterFacadeServiceV2(MapClusterFacadeService mapClusterFacadeService, CsvService csvService, CctvFacadeService cctvFacadeService) {
		this.mapClusterFacadeService = mapClusterFacadeService;
		this.csvService = csvService;
		this.cctvFacadeService = cctvFacadeService;
	}

	public void register(MapClusterRegisterForm registerForm) {
		mapClusterFacadeService.insert(MapClusterInsertForm.fromRegisterForm(registerForm));
	}

	public void register(MapClusterRegisterFileForm registerForm) {
		List<MapClusterInsertForm> insertForms = csvService.read(Paths.get(registerForm.getFilePath()).toFile(), line -> {
			MapClusterInsertForm insertForm = new MapClusterInsertForm();
			insertForm.setClusterName(line[0]);
			insertForm.setClusterId(line[1]);
			insertForm.setDescription(line[0]);
			DecimalFormat decimalFormat = new DecimalFormat();
			decimalFormat.setParseBigDecimal(true);
			try {
				insertForm.setDisplayLocation(Geolocation.of((BigDecimal) decimalFormat.parse(line[2]), (BigDecimal) decimalFormat.parse(line[3])));
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			return insertForm;
		});

		insertForms.forEach(mapClusterFacadeService::insert);
	}

	public List<MapClusteredCctvDto> getClusteredCctvs(MapBoundSearchForm searchForm) {
		Map<String, MapCluster> mapClusters = mapClusterFacadeService.listMapClusters().stream() //FIXME 지금 데이터가 적어서 전부 가져오는데 사실 그럴 필요는 없음
			.collect(Collectors.toMap(MapCluster::getClusterId, mapCluster -> mapCluster));

		CctvSearchConditions conditions = new CctvSearchConditions();
		conditions.setMapBound(searchForm.toMapBound());
		Map<String, Long> cctvCountByClusterId = cctvFacadeService.listCctvs(conditions).stream()
			.collect(Collectors.groupingBy(Cctv::getClusterId, Collectors.counting()));

		return cctvCountByClusterId.entrySet().stream()
			.map(entry -> MapClusteredCctvDto.from(mapClusters.get(entry.getKey()), entry.getValue()))
			.collect(Collectors.toList());
	}

}
