package com.example.demo.core;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.geo.Country;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CountryServiceQuery implements CountryQuery {

    private final CountryPersistencePort countryPersistencePort;

    @Override
    public Optional<Country> findById(final Long countryId) {
        return countryPersistencePort.findById(countryId);
    }

    @Override
    public PagingResponse<Country> findAll(final PagingRequest pagingRequest) {
        return countryPersistencePort.findAll(pagingRequest);
    }

}
