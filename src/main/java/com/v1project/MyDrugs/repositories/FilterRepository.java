package com.v1project.MyDrugs.repositories;

import com.v1project.MyDrugs.models.Filter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {
    List<Filter> findByActive(int val);
    Filter findById(int id);
}
