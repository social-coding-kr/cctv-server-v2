package com.socialcoding.domain.cctv.repository;

import com.socialcoding.domain.base.entity.CctvServerRepository;
import com.socialcoding.domain.cctv.entity.CctvEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CctvRepository extends CctvServerRepository<CctvEntity, Long> {

	Optional<CctvEntity> findOneById(Long id);

}
