package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.UserCctvEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserCctv extends Cctv {

	private String cctvImage;

	private String noticeImage;

	private Map<String, String> extraProperties = new HashMap<>();

	public static UserCctv fromEntity(UserCctvEntity entity) {
		UserCctv model = new UserCctv();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setLocation(Geolocation.fromEntity(entity.getLocation()));
		model.setAddress(Address.fromEntity(entity.getAddress()));
		model.setType(entity.getType());
		model.setExtraProperties(entity.getExtraProperties().entrySet().stream()
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
		return model;
	}

}
