package com.insurancepolicy.insurancepolicy.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the policy_holder database table.
 * 
 */
@Entity
@Table(name="policy_holder")
@Data
public class PolicyHolder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="POLICY_HOLDER_POLICYHOLDERID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POLICY_HOLDER_POLICYHOLDERID_GENERATOR")
	@Column(name="policy_holder_id")
	private Long policyHolderId;

	private Integer age;

	private String gender;

	@Column(name="mobile_number")
	private Long mobileNumber;

	@Column(name="policy_holder_name")
	private String policyHolderName;

	@Column(name="purchage_date")
	private LocalDate purchageDate;

	private String status;

	//bi-directional many-to-one association to Policy
	@ManyToOne
	@JoinColumn(name="policy_id")
	private Policy policy;

	public PolicyHolder() {
	}

}