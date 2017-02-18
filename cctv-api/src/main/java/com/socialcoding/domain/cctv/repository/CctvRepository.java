package com.socialcoding.domain.cctv.repository;

import com.socialcoding.domain.cctv.model.Cctv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CctvRepository extends JpaRepository<Long, Cctv> {
}
