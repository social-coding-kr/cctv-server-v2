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

	public List<MapClusteredCctvDto> listClusteredCctv(MapBoundSearchForm searchForm) {
		MapClusterSearchConditions mapClusterSearchConditions = new MapClusterSearchConditions();
		mapClusterSearchConditions.setMapBound(searchForm.toMapBound());
		return mapClusterFacadeService.listMapClusters(mapClusterSearchConditions)
			.collectMap(MapCluster::getClusterId)
			.flatMap(this::getClusteredCctvsFromMapClusters)
			.collectList()
			.block();
	}

	private Flux<MapClusteredCctvDto> getClusteredCctvsFromMapClusters(Map<String, MapCluster> mapClusters) {
		CctvClusterConditions cctvClusterConditions = new CctvClusterConditions();
		cctvClusterConditions.setClusterIds(mapClusters.keySet());
		return cctvFacadeService.listClusteredCctv(cctvClusterConditions)
			.map(clusteredCctv -> MapClusteredCctvDto.from(mapClusters.get(clusteredCctv.getClusterId()), clusteredCctv.getCount()));
	}

}
