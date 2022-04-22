package com.example.demo.persistence.repository.geo;

import com.example.demo.persistence.model.geo.JpaCity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCityRepository extends PagingAndSortingRepository<JpaCity, Long> {

}
