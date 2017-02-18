package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.GeolocationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor(staticName = "of")
public class Geolocation {

    private BigDecimal latitude;

    private BigDecimal longitude;

    public static Geolocation fromEntity(GeolocationEntity entity) {
    	return Geolocation.of(entity.getLatitude(), entity.getLongitude());
	}

}
