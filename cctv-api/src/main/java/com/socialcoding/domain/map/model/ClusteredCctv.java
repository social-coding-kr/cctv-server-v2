package com.socialcoding.domain.map.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class ClusteredCctv {

	private String clusterId;

	private long count;

	@QueryProjection
	public ClusteredCctv(String clusterId, long count) {
		this.clusterId = clusterId;
		this.count = count;
	}

}
