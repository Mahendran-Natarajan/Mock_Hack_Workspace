package com.scrotify.matrimony.dto;

import lombok.NoArgsConstructor;

/**
 * The type Search request dto.
 */
@NoArgsConstructor
public class SearchRequestDto {

    private Integer age;
    private Long stateId;
    private Long cityId;
    private Long genderId;
    private Long religionId;

    /**
     * Gets age.
     *
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Integer age) {
        this.age = age;
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
}
