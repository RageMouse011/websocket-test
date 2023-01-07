package com.ragemouse.listofcities.service;

import com.ragemouse.listofcities.entity.City;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CityService {
    Iterable<City> allCities();
    Optional<City> getCity(Long cityId);
    ResponseEntity<?> addCity(City city);
    ResponseEntity<?> updateCity(City city, Long cityId);
    ResponseEntity<?> deleteCity(Long cityId);

}
