package com.socialcoding.domain.map.model;

import com.socialcoding.domain.cctv.model.Geolocation;
import com.socialcoding.domain.map.entity.MapClusterEntity;
import com.socialcoding.interfaces.api.internal.map.dto.MapClusterRegisterForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapClusterInsertForm {

	private String clusterId;

	private String clusterName;

	private String description;

	private Geolocation displayLocation;

	public static MapClusterInsertForm fromRegisterForm(MapClusterRegisterForm registerForm) {
		MapClusterInsertForm insertForm = new MapClusterInsertForm();
		insertForm.setClusterId(registerForm.getClusterId());
		insertForm.setClusterName(registerForm.getClusterName());
		insertForm.setDescription(registerForm.getDescription());
		insertForm.setDisplayLocation(Geolocation.of(registerForm.getLatitude(), registerForm.getLongitude()));
		return insertForm;
	}

	public MapClusterEntity toEntity() {
		MapClusterEntity entity = new MapClusterEntity();
		entity.setClusterId(this.clusterId);
		entity.setClusterName(this.clusterName);
		entity.setDescription(this.description);
		entity.setDisplayLocation(this.displayLocation.toEntity());
		return entity;
	}

}
