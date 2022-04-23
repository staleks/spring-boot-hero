package com.example.demo.persistence.geo.repository;

import com.example.demo.persistence.geo.model.JpaCity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCityRepository extends PagingAndSortingRepository<JpaCity, Long> {

}
