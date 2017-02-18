package com.socialcoding.domain.base.search;

import com.querydsl.core.types.Predicate;

public interface SearchConditions {

	Predicate toPredicate();

}
