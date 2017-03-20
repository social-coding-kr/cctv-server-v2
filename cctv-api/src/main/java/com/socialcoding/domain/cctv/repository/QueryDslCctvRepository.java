package com.socialcoding.domain.cctv.repository;

import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.map.model.ClusteredCctv;

import java.util.List;

public interface QueryDslCctvRepository {

	List<ClusteredCctv> groupByClusterId(Predicate predicate);

}
