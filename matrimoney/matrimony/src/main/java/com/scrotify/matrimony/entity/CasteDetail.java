package com.scrotify.matrimony.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the caste_details database table.
 * 
 */
@Entity
@Table(name="caste_details")
//@NamedQuery(name="CasteDetail.findAll", query="SELECT c FROM CasteDetail c")
public class CasteDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CASTE_DETAILS_CASTEID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CASTE_DETAILS_CASTEID_GENERATOR")
	@Column(name="caste_id")
	private Long casteId;

	@Column(name="caste_name")
	private String casteName;

	//bi-directional many-to-one association to ReligionDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="religion_id")
	private ReligionDetail religionDetail;

    /**
     * Instantiates a new Caste detail.
     */
    public CasteDetail() {
    }

    /**
     * Gets caste id.
     *
     * @return the caste id
     */
    public Long getCasteId() {
        return this.casteId;
    }

    /**
     * Sets caste id.
     *
     * @param casteId the caste id
     */
    public void setCasteId(Long casteId) {
        this.casteId = casteId;
    }

	public String getCasteName() {
		return this.casteName;
	}

	public void setCasteName(String casteName) {
		this.casteName = casteName;
	}

	public ReligionDetail getReligionDetail() {
		return this.religionDetail;
	}

	public void setReligionDetail(ReligionDetail religionDetail) {
		this.religionDetail = religionDetail;
	}

}