package com.socialcoding.domain.cctv.repository;

import com.socialcoding.domain.base.entity.CctvServerRepository;
import com.socialcoding.domain.cctv.entity.CctvEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CctvRepository extends CctvServerRepository<CctvEntity, Long>, QueryDslCctvRepository {

//	CctvEntity findOneById(Long id);

	CctvEntity findOneByName(String name);

}
