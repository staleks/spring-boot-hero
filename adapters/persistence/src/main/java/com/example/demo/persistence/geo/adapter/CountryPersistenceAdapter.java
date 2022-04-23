package com.example.demo.persistence.geo.adapter;

import com.example.demo.core.geo.CountryPersistencePort;
import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.geo.Country;
import com.example.demo.persistence.geo.model.JpaCountry;
import com.example.demo.persistence.geo.repository.JpaCountryRepository;
import com.example.demo.persistence.util.PageRequestUtil;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.persistence.geo.mapper.CountryMapper.COUNTRY_JPA_ADAPTER_MAPPER;

@RequiredArgsConstructor
public class CountryPersistenceAdapter implements CountryPersistencePort {

    private final JpaCountryRepository jpaCountryRepository;

    @Override
    public Optional<Country> findById(final Long countryId) {
        var jpaCountry = jpaCountryRepository.findById(countryId);
        if (jpaCountry.isPresent()) {
            var jpaCountryItem = jpaCountry.get();
            return Optional.of(COUNTRY_JPA_ADAPTER_MAPPER.entityToDomain(jpaCountryItem));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public PagingResponse<Country> findAll(final PagingRequest pagingRequest) {
        var dbCountries = jpaCountryRepository.findAll(PageRequestUtil.fromPageRequestToPageable(pagingRequest));
        var countriesList = dbCountries.stream().map(COUNTRY_JPA_ADAPTER_MAPPER::entityToDomain).collect(Collectors.toList());
        return new PagingResponse<>(countriesList, dbCountries.getTotalPages(), pagingRequest.getPage(), pagingRequest.getSize());
    }

    @Override
    public Country create(final Country country) {
        return COUNTRY_JPA_ADAPTER_MAPPER.entityToDomain(jpaCountryRepository.save(JpaCountry.create(country.getAlpha2(), country.getAlpha3(), country.getName())));
    }

}
