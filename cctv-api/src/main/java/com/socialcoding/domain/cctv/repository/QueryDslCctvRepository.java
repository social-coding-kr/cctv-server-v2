package com.socialcoding.domain.cctv.repository;

import com.querydsl.core.types.Predicate;

import java.util.Map;

public interface QueryDslCctvRepository {

//	List<ClusteredCctv> groupByClusterId(Predicate predicate);

	Map<String, Long> groupByClusterId(Predicate predicate);

}
