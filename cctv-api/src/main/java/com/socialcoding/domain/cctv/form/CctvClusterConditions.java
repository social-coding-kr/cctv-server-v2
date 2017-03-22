package com.socialcoding.domain.cctv.form;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.base.search.SearchConditions;
import com.socialcoding.domain.base.util.StringUtils;
import com.socialcoding.domain.cctv.entity.QCctvEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class CctvClusterConditions implements SearchConditions {

	private String clusterId;

	@Override
	public Predicate toPredicate() {
		QCctvEntity qCctvEntity = QCctvEntity.cctvEntity;
		BooleanBuilder booleanBuilder = new BooleanBuilder();

		Optional.ofNullable(clusterId)
			.filter(StringUtils::isNotBlank)
			.ifPresent(bound -> booleanBuilder.and(qCctvEntity.clusterId.eq(clusterId)));
		return booleanBuilder;
	}

}
