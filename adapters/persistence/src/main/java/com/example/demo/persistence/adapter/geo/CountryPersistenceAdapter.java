package com.example.demo.persistence.adapter.geo;

import com.example.demo.core.CountryPersistencePort;
import com.example.demo.domain.geo.Country;
import com.example.demo.persistence.model.geo.JpaCountry;
import com.example.demo.persistence.repository.geo.JpaCountryRepository;
import lombok.RequiredArgsConstructor;

import static com.example.demo.persistence.mapper.geo.CountryMapper.COUNTRY_JPA_ADAPTER_MAPPER;


@RequiredArgsConstructor
public class CountryPersistenceAdapter implements CountryPersistencePort {

    private final JpaCountryRepository jpaCountryRepository;

    @Override
    public Country create(final Country country) {
        return COUNTRY_JPA_ADAPTER_MAPPER.entityToDomain(jpaCountryRepository.save(JpaCountry.create(country.getAlpha2(), country.getAlpha3(), country.getName())));
    }

}
