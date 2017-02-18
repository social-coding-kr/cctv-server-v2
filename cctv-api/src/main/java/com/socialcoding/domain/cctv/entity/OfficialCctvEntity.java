package com.socialcoding.domain.cctv.entity;

import com.socialcoding.domain.base.entity.MapConverter;
import com.socialcoding.domain.cctv.model.CctvType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "official_cctvs")
@DiscriminatorValue(CctvType.Names.OFFICIAL)
public class OfficialCctvEntity extends CctvEntity {

	@Column(name = "data_source")
	private String dataSource;

	@Column(name = "extra_properties")
	@Convert(converter = MapConverter.class)
	private Map<String, String> extraProperties = new HashMap<>();

}
