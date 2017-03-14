package com.socialcoding.domain.cctv.entity;

import com.socialcoding.domain.base.entity.AbstractAuditingEntity;
import com.socialcoding.domain.cctv.model.CctvType;
import com.socialcoding.domain.common.entity.GeolocationEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Table(name = "cctvs")
public abstract class CctvEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	private String clusterId;

	@Embedded
	private GeolocationEntity location;

	@Embedded
	private AddressEntity address;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", insertable = false, updatable = false)
    private CctvType type;

}
