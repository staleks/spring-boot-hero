package com.example.demo.web.endpoint;

import com.example.demo.core.geo.CityQuery;
import com.example.demo.core.util.PagingRequest;
import com.example.demo.core.util.PagingResponse;
import com.example.demo.domain.geo.City;
import com.example.demo.domain.geo.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.demo.core.util.PagingRequest.PAGE;
import static com.example.demo.core.util.PagingRequest.SIZE;
import static com.example.demo.core.util.PagingRequest.SORT;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class CityController {

    private static final String CITIES_ENDPOINT = "/geo/cities";
    private static final String CITIES_ENDPOINT_FOR_ID = "/geo/cities/{cityId}";

    private static final String CITIES_FOR_COUNTRY_ENDPOINT = "/geo/countries/{countryId}/cities";
    private static final String CITIES_FOR_COUNTRY_ENDPOINT_FOR_ID = "/geo/countries/{countryId}/cities/{cityId}";

    private final CityQuery cityQuery;


    @GetMapping(value = CITIES_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagingResponse<City>> handleGetAll(@RequestParam(value = PAGE, required = false) Integer page,
                                                   @RequestParam(value = SIZE, required = false) Integer size,
                                                   @RequestParam(value = SORT, required = false) String sort) {
        var cities = cityQuery.findAll(PagingRequest.of(page, size, sort));
        return ok(new PagingResponse<City>(cities.getItems(), cities.getTotalPages(), cities.getPage(), cities.getSize()));
    }

}
