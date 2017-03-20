package com.socialcoding.interfaces.api.v1.cctv.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Deprecated
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CctvRegistrationForm {

    @NotNull
    private BigDecimal latitude;

    @NotNull
    private BigDecimal longitude;

    private String purpose;

}
