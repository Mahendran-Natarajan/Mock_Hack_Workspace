package com.scrotify.matrimony.service;

import com.scrotify.matrimony.dto.SearchRequestDto;
import com.scrotify.matrimony.dto.SearchResponseDto;

import java.util.List;

/**
 * The interface Search service.
 */
public interface SearchService {

//    List<StateDetail> getAllStates();
//
//    List<CityDetail> getAllCities(Long stateId) throws MatrimonyException;
//
//    public List<CityDetail> getAllCities();

    /**
     * Search users by list.
     *
     * @param searchRequestDto the search request dto
     * @return the list
     */
    public List<SearchResponseDto> searchUsersBy(SearchRequestDto searchRequestDto);

}
