package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.base.entity.AbstractAuditingEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "category")
//@ToString(exclude = "comments")
@Table(name = "cctvs")
public abstract class Cctv extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Embedded
	private Geolocation location;

	@Embedded
	private Address address;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", insertable = false, updatable = false)
    private CctvCategory category;

}
