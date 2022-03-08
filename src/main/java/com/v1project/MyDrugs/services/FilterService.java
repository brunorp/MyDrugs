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

    public Filter activeFilter(int id) {
        try{
            Filter filter = filterRepository.findById(id);
            if(filter != null && filter.getActive() != 1){
                filter.setActive(1);
                filterRepository.save(filter);
                return filter;
            }else{
                throw new RuntimeException("Filter does not exist");
            }
        }catch(RuntimeException e){
            throw new RuntimeException("Error activating filter.", e);
        }

    }

    public Filter disableFilter(int id) {
        try{
            Filter filter = filterRepository.findById(id);
            filter.setActive(0);
            filterRepository.save(filter);
            return filter;
        }catch(RuntimeException e) {
            throw new RuntimeException("Error disabling filter.", e);
        }
    }
}
