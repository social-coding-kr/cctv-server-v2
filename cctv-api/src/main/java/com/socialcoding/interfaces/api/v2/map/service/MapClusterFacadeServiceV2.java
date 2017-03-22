package com.socialcoding.interfaces.api.v2.map.service;

import com.socialcoding.domain.cctv.form.CctvClusterConditions;
import com.socialcoding.domain.cctv.service.CctvFacadeService;
import com.socialcoding.domain.map.form.MapClusterSearchConditions;
import com.socialcoding.domain.map.model.MapCluster;
import com.socialcoding.domain.map.service.MapClusterFacadeService;
import com.socialcoding.interfaces.api.v2.map.dto.MapBoundSearchForm;
import com.socialcoding.interfaces.api.v2.map.dto.MapClusteredCctvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

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
		MapClusterSearchConditions mapClusterSearchConditions = new MapClusterSearchConditions();
		mapClusterSearchConditions.setMapBound(searchForm.toMapBound());
		return mapClusterFacadeService.listMapClusters(mapClusterSearchConditions)
			.flatMap(this::getClusteredCctvs)
			.collectList()
			.block();
	}

	private Flux<MapClusteredCctvDto> getClusteredCctvs(MapCluster mapCluster) {
		CctvClusterConditions cctvClusterConditions = new CctvClusterConditions();
		cctvClusterConditions.setClusterId(mapCluster.getClusterId());
		return cctvFacadeService.getClusteredCctvs(cctvClusterConditions)
			.map(clusteredCctv -> MapClusteredCctvDto.from(mapCluster, clusteredCctv.getCount()));
	}

}
