package com.socialcoding.domain.map.entity;

import com.socialcoding.domain.base.entity.AbstractAuditingEntity;
import com.socialcoding.domain.common.entity.GeolocationEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "map_clusters")
public class MapClusterEntity extends AbstractAuditingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "clusterId", unique = true)
	private String clusterId;

	private String clusterName;

	private String description;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "latitude", column = @Column(name = "display_latitude")),
		@AttributeOverride(name = "longitude", column = @Column(name = "display_longitude"))
	})
	private GeolocationEntity displayLocation;

}
