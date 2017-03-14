package com.socialcoding.domain.map.repository;

import com.socialcoding.domain.base.entity.CctvServerRepository;
import com.socialcoding.domain.map.entity.MapClusterEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface MapClusterRepository extends CctvServerRepository<MapClusterEntity, Long> {
}
