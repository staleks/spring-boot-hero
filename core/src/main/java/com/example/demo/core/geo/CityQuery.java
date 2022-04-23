package com.example.demo.core.geo;

import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.geo.City;

public interface CityQuery {
    PagingResponse<City> findAll(PagingRequest pagingRequest);
}
