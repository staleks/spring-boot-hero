package com.example.demo.core;

import com.example.demo.domain.geo.Country;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateCountryService implements CreateCountryUseCase {

    private final CountryPersistencePort countryPersistencePort;

    @Override
    public Country createCountry(final String alpha2, final String alpha3, final String name) {
        return countryPersistencePort.create(Country.create(alpha2, alpha3, name));
    }

}
