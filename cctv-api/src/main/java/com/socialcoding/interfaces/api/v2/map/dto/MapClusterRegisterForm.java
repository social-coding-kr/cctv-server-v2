package com.socialcoding.interfaces.api.v2.map.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MapClusterRegisterForm {

	private String clusterId;

	private String clusterName;

	private String description;

	private BigDecimal latitude;

	private BigDecimal longitude;

}
