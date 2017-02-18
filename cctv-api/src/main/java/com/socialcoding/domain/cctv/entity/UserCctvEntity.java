package com.socialcoding.domain.cctv.entity;

import com.socialcoding.domain.base.entity.MapConverter;
import com.socialcoding.domain.cctv.model.CctvType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "user_cctvs")
@DiscriminatorValue(CctvType.Names.USER)
public class UserCctvEntity extends CctvEntity {

	@Column(name = "cctvImage")
	private String cctvImage;

	@Column(name = "noticeImage")
	private String noticeImage;

	@Column(name = "extraProperties")
	@Convert(converter = MapConverter.class)
	private Map<String, String> extraProperties;

}
