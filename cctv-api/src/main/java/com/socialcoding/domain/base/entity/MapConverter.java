package com.socialcoding.domain.base.entity;

import com.socialcoding.domain.base.util.JsonUtils;

import javax.persistence.AttributeConverter;
import java.util.Map;

public class MapConverter implements AttributeConverter<Map, String> {

	@Override
	public String convertToDatabaseColumn(Map attribute) {
		return JsonUtils.stringify(attribute);
	}

	@Override
	public Map convertToEntityAttribute(String dbData) {
		return JsonUtils.parse(dbData, Map.class);
	}

}
