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
@Table(name = "official_cctvs")
@DiscriminatorValue(CctvCategory.Names.OFFICIAL)
public class OfficialCctv extends Cctv {

	@Column(name = "purpose")
	private String purpose;

	@Column(name = "\"range\"")
	private String range;

	@Column(name = "department")
	private String department;

	@Column(name = "pixel")
	private String pixel;

	@Column(name = "form")
	private String form;

	@Column(name = "installedAt")
	private String installedAt;

}
