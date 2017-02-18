package com.socialcoding.domain.cctv.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user_cctvs")
@DiscriminatorValue(CctvCategory.Names.USER)
public class UserCctv extends Cctv {

	@Column(name = "cctvImage")
	private String cctvImage;

	@Column(name = "noticeImage")
	private String noticeImage;

}
