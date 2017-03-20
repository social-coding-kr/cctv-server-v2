package com.socialcoding.domain.cctv.model;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.base.search.SearchConditions;
import com.socialcoding.domain.cctv.entity.QCctvEntity;
import com.socialcoding.domain.map.model.MapBound;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class CctvClusterConditions implements SearchConditions {

	private MapBound mapBound;

	@Override
	public Predicate toPredicate() {
		QCctvEntity qCctvEntity = QCctvEntity.cctvEntity;
		BooleanBuilder booleanBuilder = new BooleanBuilder();

		booleanBuilder.and(qCctvEntity.clusterId.isNotNull());

		Optional.ofNullable(mapBound)
			.ifPresent(bound -> booleanBuilder
				.and(qCctvEntity.location.latitude.between(bound.getSouth(), bound.getNorth()))
				.and(qCctvEntity.location.longitude.between(bound.getWest(), bound.getEast())));
		return booleanBuilder;
	}

}
