package com.socialcoding.domain.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public abstract class JsonUtils {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static String stringify(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error("Fail to convert map to json", e);
			throw new IllegalArgumentException("Fail to convert map to json", e);
		}
	}

	public static <T> T parse(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			log.error("Fail to convert json to map", e);
			throw new IllegalArgumentException("Fail to convert json to map", e);
		}
	}

}
