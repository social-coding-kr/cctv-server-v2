package com.socialcoding.domain.cctv.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Embeddable
public class Geolocation {

	@Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

	@Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

}
