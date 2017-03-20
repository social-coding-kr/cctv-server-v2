package com.socialcoding.domain.cctv.repository;

import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.entity.QCctvEntity;
import com.socialcoding.domain.map.model.ClusteredCctv;
import com.socialcoding.domain.map.model.QClusteredCctv;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class CctvRepositoryImpl extends QueryDslRepositorySupport implements QueryDslCctvRepository {

	private QCctvEntity qCctvEntity = QCctvEntity.cctvEntity;

	public CctvRepositoryImpl() {
		super(CctvEntity.class);
	}

	@Override
	public List<ClusteredCctv> groupByClusterId(Predicate predicate) {
		return from(qCctvEntity)
			.where(predicate)
			.groupBy(qCctvEntity.clusterId)
			.select(new QClusteredCctv(qCctvEntity.clusterId, qCctvEntity.clusterId.count().as("count")))
			.fetch();
	}

}
