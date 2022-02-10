package com.v1project.MyDrugs.services;

import com.v1project.MyDrugs.exceptions.NoFilterFoundException;
import com.v1project.MyDrugs.models.Filter;
import com.v1project.MyDrugs.repositories.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilterService {

    private final FilterRepository filterRepository;

    @Autowired
    public FilterService(FilterRepository filterRepository){
        this.filterRepository = filterRepository;
    }

    public List<Filter> getAllActiveFilters(){
        return Optional.of(filterRepository.findByActive(1)).orElseThrow(
                () -> new NoFilterFoundException("No active filters found.")
        );
    }

    public Filter createFilter(Filter filter){
        try{
            return filterRepository.save(filter);
        }catch(RuntimeException e){
            throw new RuntimeException("Error trying to create filter.", e);
        }

    }
}
