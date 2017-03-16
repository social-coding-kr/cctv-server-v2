package com.socialcoding.domain.map.model;

import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.map.entity.MapClusterEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapCluster {

	private String clusterId;

	private String clusterName;

	private String description;

	private Geolocation displayLocation;


	public static MapCluster fromEntity(MapClusterEntity entity) {
		MapCluster model = new MapCluster();
		model.setClusterId(entity.getClusterId());
		model.setClusterName(entity.getClusterName());
		model.setDisplayLocation(Geolocation.fromEntity(entity.getDisplayLocation()));
		return model;
	}

}
