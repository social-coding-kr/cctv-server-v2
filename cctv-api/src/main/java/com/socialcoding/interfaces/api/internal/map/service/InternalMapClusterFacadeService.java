package com.socialcoding.interfaces.api.internal.map.service;

import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.common.service.CsvService;
import com.socialcoding.domain.map.model.MapClusterInsertForm;
import com.socialcoding.domain.map.service.MapClusterFacadeService;
import com.socialcoding.interfaces.api.internal.map.dto.MapClusterRegisterFileForm;
import com.socialcoding.interfaces.api.internal.map.dto.MapClusterRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

@Service
public class InternalMapClusterFacadeService {

	private final MapClusterFacadeService mapClusterFacadeService;

	private final CsvService csvService;

	@Autowired
	public InternalMapClusterFacadeService(MapClusterFacadeService mapClusterFacadeService, CsvService csvService) {
		this.mapClusterFacadeService = mapClusterFacadeService;
		this.csvService = csvService;
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

}
