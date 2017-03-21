package com.socialcoding.interfaces.api.v2.map.service;

import com.socialcoding.domain.cctv.form.CctvClusterConditions;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.domain.map.model.ClusteredCctv;
import com.socialcoding.domain.map.model.MapCluster;
import com.socialcoding.domain.map.service.MapClusterFacadeService;
import com.socialcoding.interfaces.api.v2.map.dto.MapBoundSearchForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusteredCctvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
public class MapClusterFacadeServiceV2 {

	private final MapClusterFacadeService mapClusterFacadeService;

	private final CctvFacadeService cctvFacadeService;

	@Autowired
	public MapClusterFacadeServiceV2(MapClusterFacadeService mapClusterFacadeService, CctvFacadeService cctvFacadeService) {
		this.mapClusterFacadeService = mapClusterFacadeService;
		this.cctvFacadeService = cctvFacadeService;
	}

	public List<MapClusteredCctvDto> getClusteredCctvs(MapBoundSearchForm searchForm) {
		Map<String, MapCluster> mapClusters = mapClusterFacadeService.listMapClusters() //FIXME 지금 데이터가 적어서 전부 가져오는데 사실 그럴 필요는 없음
			.collectMap(MapCluster::getClusterId, mapCluster -> mapCluster)
			.block();

		CctvClusterConditions conditions = new CctvClusterConditions();
		conditions.setMapBound(searchForm.toMapBound());
		return cctvFacadeService.getClusteredCctvs(conditions)
			.collectMap(ClusteredCctv::getClusterId, ClusteredCctv::getCount)
			.flatMap(map -> Flux.fromIterable(map.entrySet()))
			.map(entry -> MapClusteredCctvDto.from(mapClusters.get(entry.getKey()), entry.getValue()))
			.collectList()
			.block();
	}

}
