package com.socialcoding.interfaces.api.v2.map.dto;

import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.map.model.MapCluster;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class MapClusteredCctvDto {

	private String clusterId;
	private String clusterName;
	private Geolocation location;

	private long count;

	public static MapClusteredCctvDto from(MapCluster mapCluster, Long count) {
		MapClusteredCctvDto dto = new MapClusteredCctvDto();
		dto.setClusterId(mapCluster.getClusterId());
		dto.setClusterName(mapCluster.getClusterName());
		dto.setLocation(mapCluster.getDisplayLocation());
		dto.setCount(Optional.ofNullable(count).orElse(0L));
		return dto;
	}
}
