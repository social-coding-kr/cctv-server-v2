package com.socialcoding.domain.cctv.repository;

import com.socialcoding.domain.base.entity.CctvServerRepository;
import com.socialcoding.domain.cctv.entity.OfficialCctvEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficialCctvRepository extends CctvServerRepository<OfficialCctvEntity, Long> {

}
