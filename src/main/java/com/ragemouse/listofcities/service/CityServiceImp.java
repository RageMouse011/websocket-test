package com.ragemouse.listofcities.service;

import com.ragemouse.listofcities.entity.City;
import com.ragemouse.listofcities.repository.CityRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class CityServiceImp implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImp(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Iterable<City> allCities() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getCity(Long cityId) {
        return cityRepository.findById(cityId);
    }

    @Override
    public ResponseEntity<?> addCity(City city) {
        cityRepository.save(city);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCityUri = ServletUriComponentsBuilder
                                    .fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(city.getId())
                                    .toUri();
        responseHeaders.setLocation(newCityUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateCity(City city, Long cityId) {
        City updatedCity = cityRepository.findById(cityId).get();
        updatedCity.setName(city.getName());
        updatedCity.setPopulation(city.getPopulation());
        updatedCity.setArea(city.getArea());
        cityRepository.save(updatedCity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
