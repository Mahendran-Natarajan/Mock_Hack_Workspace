package com.scrotify.matrimony.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Api response.
 */
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    /**
     * The Search response dto list.
     */
    List<SearchResponseDto> searchResponseDtoList;
    private String message;
    private int statusCode;

    /**
     * Gets search response dto list.
     *
     * @return the search response dto list
     */
    public List<SearchResponseDto> getSearchResponseDtoList() {
        return searchResponseDtoList;
    }

    /**
     * Sets search response dto list.
     *
     * @param searchResponseDtoList the search response dto list
     */
    public void setSearchResponseDtoList(List<SearchResponseDto> searchResponseDtoList) {
        this.searchResponseDtoList = searchResponseDtoList;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets status code.
     *
     * @param statusCode the status code
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}



