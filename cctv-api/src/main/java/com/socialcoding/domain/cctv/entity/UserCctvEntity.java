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
@Table(name = "user_cctvs")
@DiscriminatorValue(CctvType.Names.USER)
public class UserCctvEntity extends CctvEntity {

	@Column(name = "cctv_image")
	private String cctvImage;

	@Column(name = "notice_image")
	private String noticeImage;

	@Column(name = "extra_properties")
	@Convert(converter = MapConverter.class)
	private Map<String, String> extraProperties = new HashMap<>();

}
