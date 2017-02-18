package com.socialcoding.domain.base.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.io.Serializable;

public interface CctvServerRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, QueryDslPredicateExecutor<T> {
}
