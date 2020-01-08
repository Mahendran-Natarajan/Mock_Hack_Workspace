package com.scrotify.matrimony.controller;

import com.scrotify.matrimony.service.SearchService;
import com.scrotify.matrimony.service.SearchServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {


    @InjectMocks
    private SearchController searchController;

    @Mock
    private SearchServiceImpl searchService;

    @Test
    public void testSearchResults() {
        //Optional<String> age = Optional.ofNullable("29");
      //  searchController.search(age, 1, 1 , 1, 1);

    }






}
