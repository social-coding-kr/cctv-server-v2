package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CctvInsertForm {

	public abstract CctvEntity toEntity();

}
