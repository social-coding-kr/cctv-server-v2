package com.socialcoding.interfaces.api.internal.cctv.service;

import com.socialcoding.domain.cctv.model.OfficialCctvInsertForm;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.domain.common.service.CsvService;
import com.socialcoding.interfaces.api.internal.cctv.dto.OfficialCctvRegisterFileForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InternalCctvFacadeService {

	private final CctvFacadeService cctvFacadeService;

	private final CsvService csvService;

	@Autowired
	public InternalCctvFacadeService(CctvFacadeService cctvFacadeService, CsvService csvService) {
		this.cctvFacadeService = cctvFacadeService;
		this.csvService = csvService;
	}

	public void register(OfficialCctvRegisterFileForm registerForm) {

		Map<Long, Map<String, String>> official = csvService.read(Paths.get(registerForm.getOfficialCctvFilePath()).toFile(), line -> {
			Map<String, String> data = new HashMap<>();
			data.put("cctvId", line[0]);
			data.put("cctvName", line[1]);
			data.put("address", line[2]);
			data.put("borough", line[3]);
			data.put("dong", line[4]);
			data.put("range")
			return data;
		}).stream().collect(Collectors.toMap(map -> Long.parseLong(map.get("cctvId")), map -> map));

		Map<Long, Map<String, String>> common = csvService.read(Paths.get(registerForm.getCommonCctvFilePath()).toFile(), line -> {
			Map<String, String> data = new HashMap<>();
			return data;
		}).stream()
			.collect(Collectors.toMap(map -> Long.parseLong(map.get("cctvId")), map -> map));


		log.debug("count: {}, {}", official.size(), common.size());

//		mergeById(official, common).forEach(cctvFacadeService::insert);
	}

	private List<OfficialCctvInsertForm> mergeById(Map<Long, Map<String, String>> official, Map<Long, Map<String, String>> common) {
		return official.entrySet().stream()
			.filter(entry -> common.containsKey(entry.getKey()))
			.map(entry -> {
				Map<String, String> officialElements = entry.getValue();
				Map<String, String> commonElements = common.get(entry.getKey());

				Map<String, String> merged = new HashMap<>(officialElements);
				merged.putAll(commonElements);
				return merged;
			})
			.map(mergedMap -> {
				OfficialCctvInsertForm insertForm = new OfficialCctvInsertForm();
				return insertForm;
			})
			.collect(Collectors.toList());
	}

}
