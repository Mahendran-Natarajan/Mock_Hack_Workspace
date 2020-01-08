package com.scrotify.matrimony.controller;

import com.scrotify.matrimony.dto.ApiResponse;
import com.scrotify.matrimony.dto.SearchRequestDto;
import com.scrotify.matrimony.dto.SearchResponseDto;
import com.scrotify.matrimony.service.SearchServiceImpl;
import com.scrotify.matrimony.util.MatrimonyContants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Thee Search controller.
 * @author Mahendran
 */
@RestController
@RequestMapping("/search")
@CrossOrigin
public class SearchController {

    private static Logger logger = LogManager.getLogger(SearchController.class);

    @Autowired
    private SearchServiceImpl searchService;

    /**
     * Search response entity.
     *
     * @param age        the age
     * @param cityId     the city id
     * @param genderId   the gender id
     * @param religionId the religion id
     * @param stateId    the state id
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<ApiResponse> search(@RequestParam(required = false) String age,
                                              @RequestParam(required = false)  String cityId,
                                              @RequestParam (required = false) String genderId,
                                              @RequestParam (required = false) String religionId,
                                              @RequestParam (required = false) String stateId) {
        logger.info("Entering into search ");
        SearchRequestDto searchRequestDto = new SearchRequestDto();
        searchRequestDto.setReligionId(Long.parseLong(religionId));
        searchRequestDto.setGenderId(Long.parseLong(genderId));
        searchRequestDto.setStateId(Long.parseLong(stateId));
        searchRequestDto.setCityId(Long.parseLong(cityId));
        ApiResponse response = new ApiResponse();
        List<SearchResponseDto> userDetails = searchService.searchUsersBy(searchRequestDto);
        response.setSearchResponseDtoList(userDetails);
        response.setMessage(MatrimonyContants.SEARCH_SUCCESS);
        logger.info("Ending of search ");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
