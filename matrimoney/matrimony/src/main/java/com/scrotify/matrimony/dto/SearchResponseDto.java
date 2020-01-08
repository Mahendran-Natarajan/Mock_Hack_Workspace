package com.scrotify.matrimony.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

/**
 * The type Search response dto.
 */
@NoArgsConstructor
@Setter
@Getter
public class SearchResponseDto {

    private Long userId;

    private int age;

    private double annualIncome;

    private Date dob;

    private String emailId;

    private Long genderId;

    private String gothram;

    private int height;

    private BigInteger mobileNo;

    private Long maritalStatusId;

    private Long motherTongueId;

    private String name;

    private String occupation;

    private String password;

    private String workLocation;

    private Long qualificationId;

    private Long religionId;

    private Long stateId;

    private Long cityId;
    private Long mothertongueId;

    /**
     * Gets city id.
     *
     * @return the city id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * Sets city id.
     *
     * @param cityId the city id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets annual income.
     *
     * @return the annual income
     */
    public double getAnnualIncome() {
        return annualIncome;
    }

    /**
     * Sets annual income.
     *
     * @param annualIncome the annual income
     */
    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    /**
     * Gets dob.
     *
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets dob.
     *
     * @param dob the dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Gets email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets email id.
     *
     * @param emailId the email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets gender id.
     *
     * @return the gender id
     */
    public Long getGenderId() {
        return genderId;
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
     * Gets gothram.
     *
     * @return the gothram
     */
    public String getGothram() {
        return gothram;
    }

    /**
     * Sets gothram.
     *
     * @param gothram the gothram
     */
    public void setGothram(String gothram) {
        this.gothram = gothram;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets mobile no.
     *
     * @return the mobile no
     */
    public BigInteger getMobileNo() {
        return mobileNo;
    }

    /**
     * Sets mobile no.
     *
     * @param mobileNo the mobile no
     */
    public void setMobileNo(BigInteger mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * Gets marital status id.
     *
     * @return the marital status id
     */
    public Long getMaritalStatusId() {
        return maritalStatusId;
    }

    /**
     * Sets marital status id.
     *
     * @param maritalStatusId the marital status id
     */
    public void setMaritalStatusId(Long maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    /**
     * Gets mother tongue id.
     *
     * @return the mother tongue id
     */
    public Long getMotherTongueId() {
        return motherTongueId;
    }

    /**
     * Sets mother tongue id.
     *
     * @param motherTongueId the mother tongue id
     */
    public void setMotherTongueId(Long motherTongueId) {
        this.motherTongueId = motherTongueId;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets occupation.
     *
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Sets occupation.
     *
     * @param occupation the occupation
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets work location.
     *
     * @return the work location
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Sets work location.
     *
     * @param workLocation the work location
     */
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    /**
     * Gets qualification id.
     *
     * @return the qualification id
     */
    public Long getQualificationId() {
        return qualificationId;
    }

    /**
     * Sets qualification id.
     *
     * @param qualificationId the qualification id
     */
    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    /**
     * Gets religion id.
     *
     * @return the religion id
     */
    public Long getReligionId() {
        return religionId;
    }

    /**
     * Sets religion id.
     *
     * @param religionId the religion id
     */
    public void setReligionId(Long religionId) {
        this.religionId = religionId;
    }

    /**
     * Gets state id.
     *
     * @return the state id
     */
    public Long getStateId() {
        return stateId;
    }

    /**
     * Sets state id.
     *
     * @param stateId the state id
     */
    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    /**
     * Gets mothertongue id.
     *
     * @return the mothertongue id
     */
    public Long getMothertongueId() {
        return mothertongueId;
    }

    /**
     * Sets mothertongue id.
     *
     * @param mothertongueId the mothertongue id
     */
    public void setMothertongueId(Long mothertongueId) {
        this.mothertongueId = mothertongueId;
    }
}
