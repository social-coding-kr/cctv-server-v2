package com.socialcoding.interfaces.api.internal.cctv.service;

import com.socialcoding.domain.cctv.model.OfficialCctvInsertForm;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.domain.common.service.CsvService;
import com.socialcoding.interfaces.api.internal.cctv.dto.OfficialCctvRegisterFileForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

		Map<Long, Map<String, String>> common = csvService.read(Paths.get(registerForm.getCommonCctvFilePath()).toFile(), line -> {
			Map<String, String> data = new HashMap<>();
			return data;
		}).stream()
			.collect(Collectors.toMap(map -> map.get("id"), map -> map));

		Map<Long, Map<String, String>> official = csvService.read(Paths.get(registerForm.getOfficialCctvFilePath()).toFile(), line -> {

		});

		mergeById(common, official).forEach(cctvFacadeService::insert);
	}

	private List<OfficialCctvInsertForm> mergeById(Map<Long, Map<String, String>> common, Map<Long, Map<String, String>> official) {
		return null;
	}

}
