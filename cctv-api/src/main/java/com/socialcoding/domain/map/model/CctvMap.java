package com.socialcoding.domain.map.model;

import com.socialcoding.domain.cctv.model.Cctv;
import com.socialcoding.domain.cctv.model.CctvType;
import lombok.AllArgsConstructor;

import java.util.Collection;

@AllArgsConstructor(staticName = "of")
public class CctvMap {

	private Collection<Cctv> cctvs;
	private CctvType type;

	private MapBound bound;

}
