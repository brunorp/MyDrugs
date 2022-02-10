package com.v1project.MyDrugs.controllers;

import com.v1project.MyDrugs.models.Filter;
import com.v1project.MyDrugs.services.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filter")
public class FilterController {

    private final FilterService filterService;

    @Autowired
    public FilterController(FilterService filterService){
        this.filterService = filterService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Filter>> getAllActiveFilters(){
        return ResponseEntity.ok(filterService.getAllActiveFilters());
    }

    @PostMapping("/create")
    public ResponseEntity<Filter> createFilter(@RequestBody Filter filter){
        return ResponseEntity.ok(filterService.createFilter(filter));
    }
}
