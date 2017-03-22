package com.socialcoding.domain.map.form;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.socialcoding.domain.base.search.SearchConditions;
import com.socialcoding.domain.map.entity.QMapClusterEntity;
import com.socialcoding.domain.map.model.MapBound;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class MapClusterSearchConditions implements SearchConditions {

	private MapBound mapBound;

	@Override
	public Predicate toPredicate() {
		QMapClusterEntity qMapClusterEntity = QMapClusterEntity.mapClusterEntity;
		BooleanBuilder booleanBuilder = new BooleanBuilder();

		Optional.ofNullable(mapBound)
			.ifPresent(bound -> booleanBuilder
				.and(qMapClusterEntity.displayLocation.latitude.between(bound.getSouth(), bound.getNorth()))
				.and(qMapClusterEntity.displayLocation.longitude.between(bound.getWest(), bound.getEast())));
		return booleanBuilder;
	}

}
