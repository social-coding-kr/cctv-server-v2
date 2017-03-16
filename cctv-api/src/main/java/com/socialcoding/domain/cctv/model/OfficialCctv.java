package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.OfficialCctvEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class OfficialCctv extends Cctv {

	private String dataSource;

	private Map<String, String> extraProperties = new HashMap<>();

	public static OfficialCctv fromEntity(OfficialCctvEntity entity) {
		OfficialCctv model = new OfficialCctv();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setClusterId(entity.getClusterId());
		model.setLocation(Geolocation.fromEntity(entity.getLocation()));
		model.setAddress(Address.fromEntity(entity.getAddress()));
		model.setType(entity.getType());
		model.setDataSource(entity.getDataSource());
		model.setExtraProperties(entity.getExtraProperties().entrySet().stream()
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
		return model;
	}

}
