package com.insurancepolicy.insurancepolicy.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the policy database table.
 * 
 */
@Data
@Table(name = "policy")
@Entity
public class Policy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POLICY_POLICYID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POLICY_POLICYID_GENERATOR")
	@Column(name="policy_id")
	private Long policyId;

	@Column(name="min_sum_assured")
	private Double minSumAssured;

	@Column(name="policy_max_age")
	private Integer policyMaxAge;

	@Column(name="policy_max_term")
	private Integer policyMaxTerm;

	@Column(name="policy_min_age")
	private Integer policyMinAge;

	@Column(name="policy_min_premium")
	private Double policyMinPremium;

	@Column(name="policy_min_term")
	private Integer policyMinTerm;

	@Column(name="policy_name")
	private String policyName;

	//bi-directional many-to-one association to PolicyFeature
	@OneToMany(mappedBy="policy")
	private List<PolicyFeature> policyFeatures;

	//bi-directional many-to-one association to PolicyHolder
	@OneToMany(mappedBy="policy")
	private List<PolicyHolder> policyHolders;

	private String terms;

	public Policy() {
	}

	public PolicyFeature addPolicyFeature(PolicyFeature policyFeature) {
		getPolicyFeatures().add(policyFeature);
		policyFeature.setPolicy(this);

		return policyFeature;
	}

	public PolicyFeature removePolicyFeature(PolicyFeature policyFeature) {
		getPolicyFeatures().remove(policyFeature);
		policyFeature.setPolicy(null);

		return policyFeature;
	}


	public PolicyHolder addPolicyHolder(PolicyHolder policyHolder) {
		getPolicyHolders().add(policyHolder);
		policyHolder.setPolicy(this);

		return policyHolder;
	}

	public PolicyHolder removePolicyHolder(PolicyHolder policyHolder) {
		getPolicyHolders().remove(policyHolder);
		policyHolder.setPolicy(null);

		return policyHolder;
	}

}