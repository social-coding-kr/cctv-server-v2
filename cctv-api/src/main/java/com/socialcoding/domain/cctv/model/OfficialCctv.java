package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.base.entity.MapConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "official_cctvs")
@DiscriminatorValue(CctvCategory.Names.OFFICIAL)
public class OfficialCctv extends Cctv {

	@Column(name = "data_source")
	private String dataSource;

	@Column(name = "extraProperties")
	@Convert(converter = MapConverter.class)
	private Map<String, String> extraProperties;

}
