package com.example.demo.persistence.repository.geo;

import com.example.demo.persistence.model.geo.JpaCountry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCountryRepository extends PagingAndSortingRepository<JpaCountry, Long> {

}
