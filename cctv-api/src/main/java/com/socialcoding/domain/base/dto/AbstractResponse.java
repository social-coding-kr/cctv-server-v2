package com.socialcoding.domain.base.dto;

import com.socialcoding.interfaces.api.base.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractResponse {

    private ResponseStatus status;

}
