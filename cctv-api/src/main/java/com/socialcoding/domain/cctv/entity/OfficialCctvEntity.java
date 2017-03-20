package com.socialcoding.domain.cctv.entity;

import com.socialcoding.domain.base.entity.MapConverter;
import com.socialcoding.domain.cctv.model.CctvType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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




	@CreatedBy
	@Column(name = "created_by", nullable = false, length = 100, updatable = false)
	private String createdBy;

	@CreatedDate
	@Column(name = "created_date", columnDefinition = "DATETIME", nullable = false, updatable = false)
	private LocalDateTime createdDate;

	@LastModifiedBy
	@Column(name = "last_modified_by", length = 100)
	private String lastModifiedBy;

	@LastModifiedDate
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;

}
