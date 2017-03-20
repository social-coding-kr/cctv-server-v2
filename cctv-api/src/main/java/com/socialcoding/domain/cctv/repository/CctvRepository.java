package com.socialcoding.domain.cctv.repository;

import com.socialcoding.domain.base.entity.CctvServerRepository;
import com.socialcoding.domain.cctv.entity.CctvEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CctvRepository extends CctvServerRepository<CctvEntity, Long>, QueryDslCctvRepository {

	Optional<CctvEntity> findOneById(Long id);

	Optional<CctvEntity> findOneByName(String name);

//	@Query("select new com.socialcoding.domain.map.model.ClusteredCctv(v.clusterId, count(v)) from CctvEntity v group by v.clusterId")
//	List<ClusteredCctv> groupByClusterId(Predicate predicate);

//	@Query(value = "select new com.path.to.class.SurveyAnswerStatistics(v.answer, count(v)) from Survey v group by v.answer")
//	List<SurveyAnswerStatistics> findSurveyCount();
}
