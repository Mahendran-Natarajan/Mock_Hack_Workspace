package com.scrotify.matrimony.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the maritalStatus_details database table.
 */
@Entity
@Table(name = "gender_details")
public class GenderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "GENDER_DETAILS_GENDERID_GENERATOR", sequenceName = "SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENDER_DETAILS_GENDERID_GENERATOR")
    @Column(name = "gender_id")
    private Long genderId;

    private String gender;

    //bi-directional many-to-one association to UserDetail
    @OneToMany(mappedBy = "genderDetail")
    private List<UserDetail> userDetails;

    /**
     * Instantiates a new Gender detail.
     */
    public GenderDetail() {
    }

    /**
     * Gets gender id.
     *
     * @return the gender id
     */
    public Long getGenderId() {
        return this.genderId;
    }

    /**
     * Sets gender id.
     *
     * @param genderId the gender id
     */
    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets user details.
     *
     * @return the user details
     */
    public List<UserDetail> getUserDetails() {
        return this.userDetails;
    }

    /**
     * Sets user details.
     *
     * @param userDetails the user details
     */
    public void setUserDetails(List<UserDetail> userDetails) {
        this.userDetails = userDetails;
    }
}