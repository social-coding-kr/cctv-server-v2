package com.socialcoding.domain.cctv.model;

import com.socialcoding.domain.base.entity.AbstractAuditingEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "source")
//@ToString(exclude = "comments")
@Table(name = "cctvs")
public abstract class Cctv extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cctvId", nullable = false)
    private Long id;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "latitude", column = @Column(name = "latitude")),
		@AttributeOverride(name = "longitude", column = @Column(name = "longitude"))
	})
	private Geolocation location;

    @Column(name = "purpose")
    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", insertable = false, updatable = false)
    private CctvCategory category;

}
