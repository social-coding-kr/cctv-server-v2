package com.socialcoding.interfaces.api.v1.cctv.dto.response;

import com.socialcoding.interfaces.api.base.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Deprecated
@Getter
@Setter
public abstract class AbstractResponse {

    private ResponseStatus status;

}
