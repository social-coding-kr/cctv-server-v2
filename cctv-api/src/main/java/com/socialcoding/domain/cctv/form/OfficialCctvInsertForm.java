package com.socialcoding.domain.cctv.form;

import com.socialcoding.domain.cctv.entity.OfficialCctvEntity;
import com.socialcoding.domain.cctv.model.CctvType;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class OfficialCctvInsertForm extends CctvInsertForm {

	private String dataSource;

	private Map<String, String> extraProperties = new HashMap<>();

	public OfficialCctvEntity toEntity() {
		OfficialCctvEntity entity = new OfficialCctvEntity();
		entity.setName(this.getName());
		entity.setClusterId(this.getClusterId());
		entity.setLocation(this.getLocation().toEntity());
		entity.setAddress(this.getAddress().toEntity());
		entity.setDataSource(this.getDataSource());
		entity.setExtraProperties(this.getExtraProperties());
		entity.setType(CctvType.OFFICIAL);
		return entity;
	}

}
