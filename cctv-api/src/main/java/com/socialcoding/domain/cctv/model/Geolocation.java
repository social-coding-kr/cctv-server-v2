package com.socialcoding.domain.cctv.model;

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

}
