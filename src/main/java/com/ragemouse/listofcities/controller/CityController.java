package com.ragemouse.listofcities.controller;

import com.ragemouse.listofcities.entity.City;
import com.ragemouse.listofcities.service.CityServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityController {


    private final CityServiceImp cityServiceImp;

    public CityController(CityServiceImp cityServiceImp) {
        this.cityServiceImp = cityServiceImp;
    }

    @GetMapping(value="/all")
    public ResponseEntity<Iterable<City>> getAllCities() {
        return new ResponseEntity<>(cityServiceImp.allCities(), HttpStatus.OK);
    }

    @GetMapping(value="/{cityId}")
    public ResponseEntity<?> getCity(@PathVariable Long cityId) {
        Optional<City> city = cityServiceImp.getCity(cityId);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping(value="")
    public ResponseEntity<?> addCity(@RequestBody City city) {
        return cityServiceImp.addCity(city);
    }

    @PutMapping(value="/{cityId}")
    public ResponseEntity<?> updateCity(@RequestBody City city, @PathVariable Long cityId) {
        return cityServiceImp.updateCity(city, cityId);
    }

    @DeleteMapping(value="/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable Long cityId) {
        return cityServiceImp.deleteCity(cityId);
    }
}
