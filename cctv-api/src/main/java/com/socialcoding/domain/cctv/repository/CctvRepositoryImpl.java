package com.socialcoding.domain.cctv.repository;

import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.entity.QCctvEntity;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.Map;

public class CctvRepositoryImpl extends QueryDslRepositorySupport implements QueryDslCctvRepository {

	private QCctvEntity qCctvEntity = QCctvEntity.cctvEntity;

	public CctvRepositoryImpl() {
		super(CctvEntity.class);
	}

//	@Override
//	public List<ClusteredCctv> groupByClusterId(Predicate predicate) {
//		return from(qCctvEntity)
//			.where(predicate)
//			.groupBy(qCctvEntity.clusterId)
//			.select(Projections.bean(ClusteredCctv.class, qCctvEntity.clusterId, qCctvEntity.clusterId.count().as("count")))
//			.fetch();
//	}

	@Override
	public Map<String, Long> groupByClusterId(Predicate predicate) {
		return from(qCctvEntity)
			.where(predicate)
			.groupBy(qCctvEntity.clusterId)
			.transform(GroupBy.groupBy(qCctvEntity.clusterId).as(qCctvEntity.clusterId.count().as("count")));
	}

}
