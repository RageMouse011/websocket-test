package com.ragemouse.listofcities.controller;

import com.ragemouse.listofcities.entity.City;
import com.ragemouse.listofcities.service.CitiesService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("citiesWithRepo")
public class CityControllerWithRepo {

    private final CitiesService citiesService;


    //Получить все города в graphQL. После запроса обновится websocket, который отобразится в консоли.
    @QueryMapping
    @GetMapping("/allWithRepo")
    public List<City> getAllCities(){
        return citiesService.getAllCitiesWithRepository();
    }


    @MutationMapping
    @PostMapping("/createNewCity")
    public City createNewCity(@RequestBody @Argument City city){
        return citiesService.createCity(city);
    }

}
