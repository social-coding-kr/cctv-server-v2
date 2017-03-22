package com.socialcoding.domain.cctv.form;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.base.search.SearchConditions;
import com.socialcoding.domain.base.util.CollectionUtils;
import com.socialcoding.domain.cctv.entity.QCctvEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public class CctvClusterConditions implements SearchConditions {

	private Set<String> clusterIds;

	@Override
	public Predicate toPredicate() {
		QCctvEntity qCctvEntity = QCctvEntity.cctvEntity;
		BooleanBuilder booleanBuilder = new BooleanBuilder();

		Optional.ofNullable(clusterIds)
			.filter(CollectionUtils::isNotEmpty)
			.ifPresent(bound -> booleanBuilder.and(qCctvEntity.clusterId.in(clusterIds)));
		return booleanBuilder;
	}

}
