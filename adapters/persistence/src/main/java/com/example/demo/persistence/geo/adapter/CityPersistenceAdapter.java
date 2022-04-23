package com.example.demo.persistence.geo.adapter;

import com.example.demo.core.geo.CityPersistencePort;
import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.error.ResourceNotFoundException;
import com.example.demo.domain.geo.City;
import com.example.demo.persistence.geo.model.JpaCity;
import com.example.demo.persistence.geo.model.JpaCountry;
import com.example.demo.persistence.geo.repository.JpaCityRepository;
import com.example.demo.persistence.geo.repository.JpaCountryRepository;
import com.example.demo.persistence.util.PageRequestUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.domain.error.ResourceNotFoundException.NO_RESOURCE_WITH_ID;
import static com.example.demo.persistence.geo.mapper.CountryMapper.COUNTRY_JPA_ADAPTER_MAPPER;

@RequiredArgsConstructor
public class CityPersistenceAdapter implements CityPersistencePort {

    private final JpaCountryRepository jpaCountryRepository;
    private final JpaCityRepository jpaCityRepository;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public PagingResponse<City> findAll(final PagingRequest pagingRequest) {
        var dbCities = jpaCityRepository.findAll(PageRequestUtil.fromPageRequestToPageable(pagingRequest));
        List<City> citiesList = new ArrayList<>();
        for (JpaCity jpaCityItem: dbCities.getContent()) {
            Optional<JpaCountry> countryItem = jpaCountryRepository.findById(jpaCityItem.getCountry().getId());
            City city = City.of(jpaCityItem.getId(), jpaCityItem.getZipCode(), jpaCityItem.getName(), jpaCityItem.isActive(), countryItem.map(COUNTRY_JPA_ADAPTER_MAPPER::entityToDomain).orElseThrow(() -> new ResourceNotFoundException(String.format(NO_RESOURCE_WITH_ID, jpaCityItem.getCountry().getId()))));
            citiesList.add(city);
        }
        return new PagingResponse<>(citiesList, dbCities.getTotalPages(), pagingRequest.getPage(), pagingRequest.getSize());
    }

}
