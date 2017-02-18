package com.socialcoding.domain.map.model;

import com.socialcoding.domain.cctv.entity.CctvEntity;
import com.socialcoding.domain.cctv.model.CctvType;

import java.util.Collection;

public class CctvMap {

	private Collection<CctvEntity> cctvs;
	private CctvType category;

	private MapBound bound;

}
