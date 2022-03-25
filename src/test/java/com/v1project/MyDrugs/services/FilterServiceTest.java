package com.v1project.MyDrugs.services;

import com.v1project.MyDrugs.models.Filter;
import com.v1project.MyDrugs.repositories.FilterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FilterServiceTest {
    @Mock
    private FilterRepository filterRepository;

    @InjectMocks
    private FilterService filterService;

    @Test
    void getAllActiveFilters(){
        List<Filter> filters = new ArrayList<>();
        filters.add(new Filter());
        when(filterService.getAllActiveFilters()).thenReturn(filters);
        filterService.getAllActiveFilters();

        verify(filterRepository,times(1)).findByActive(anyInt());
    }

    @Test
    void createFilter() {
    }

    @Test
    void activeFilter() {
    }

    @Test
    void disableFilter() {
    }
}