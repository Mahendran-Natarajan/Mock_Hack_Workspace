package com.insurancepolicy.insurancepolicy.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the policy_feature database table.
 * 
 */
@Entity
@Table(name="policy_feature")
@Data
public class PolicyFeature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POLICY_FEATURE_FEATUREID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POLICY_FEATURE_FEATUREID_GENERATOR")
	@Column(name="feature_id")
	private Long featureId;

	@Lob
	@Column(name="feature_details")
	private String featureDetails;

	@Column(name="feature_heading")
	private String featureHeading;

	@Column(name="feature_name")
	private String featureName;

	@Column(name="feature_order")
	private Integer featureOrder;

	//bi-directional many-to-one association to Policy
	@ManyToOne
	@JoinColumn(name="policy_id")
	private Policy policy;

	public PolicyFeature() {
	}

}