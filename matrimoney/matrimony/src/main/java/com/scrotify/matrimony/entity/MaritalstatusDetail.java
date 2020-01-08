package com.scrotify.matrimony.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the maritalStatus_details database table.
 */
@Entity
@Table(name = "maritalstatus_details")
public class MaritalstatusDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "MARITALSTATUS_DETAILS_MARITALSTATUSID_GENERATOR", sequenceName = "SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MARITALSTATUS_DETAILS_MARITALSTATUSID_GENERATOR")
    @Column(name = "maritalstatus_id")
    private Long maritalstatusId;

    @Column(name = "marital_status")
    private String maritalStatus;

    //bi-directional many-to-one association to UserDetail
    @OneToMany(mappedBy = "maritalstatusDetail")
    private List<UserDetail> userDetails;


    /**
     * Gets maritalstatus id.
     *
     * @return the maritalstatus id
     */
    public Long getMaritalstatusId() {
        return maritalstatusId;
    }

    /**
     * Sets maritalstatus id.
     *
     * @param maritalstatusId the maritalstatus id
     */
    public void setMaritalstatusId(Long maritalstatusId) {
        this.maritalstatusId = maritalstatusId;
    }

    /**
     * Gets marital status.
     *
     * @return the marital status
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets marital status.
     *
     * @param maritalStatus the marital status
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Gets user details.
     *
     * @return the user details
     */
    public List<UserDetail> getUserDetails() {
        return userDetails;
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