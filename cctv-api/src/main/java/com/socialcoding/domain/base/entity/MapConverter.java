package com.socialcoding.domain.base.entity;

import com.socialcoding.domain.base.util.JsonUtils;

import javax.persistence.AttributeConverter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapConverter implements AttributeConverter<Map, String> {

	@Override
	public String convertToDatabaseColumn(Map attribute) {
		return Optional.ofNullable(attribute)
			.filter(map -> !attribute.isEmpty())
			.map(JsonUtils::stringify)
			.orElse(null);
	}

	@Override
	public Map convertToEntityAttribute(String dbData) {
		return Optional.ofNullable(dbData)
			.map(data -> JsonUtils.parse(dbData, Map.class))
			.orElse(new HashMap<String, String>());
	}

}
