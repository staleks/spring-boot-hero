package com.example.demo.persistence.geo.repository;

import com.example.demo.persistence.geo.model.JpaCountry;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCountryRepository extends PagingAndSortingRepository<JpaCountry, Long> {

}
