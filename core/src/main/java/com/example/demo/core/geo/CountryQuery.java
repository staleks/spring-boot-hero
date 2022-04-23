package com.example.demo.core.geo;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.geo.Country;

import java.util.Optional;

public interface CountryQuery {

    Optional<Country> findById(final Long countryId);

    PagingResponse<Country> findAll(PagingRequest pagingRequest);

}
