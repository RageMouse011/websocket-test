package com.ragemouse.listofcities.service;

import com.ragemouse.listofcities.entity.City;
import com.ragemouse.listofcities.repository.CityRepository;
import com.ragemouse.listofcities.util.EventClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CitiesService {

    private final CityRepository cityRepository;

    public List<City> getAllCitiesFromWebSocket(){
        List<City> findAllCities = cityRepository.findAll();
        String allCities = findAllCities.toString();
        EventClient.createEventClient(allCities);
        return findAllCities;
    }

    public List<City> getAllCitiesWithRepository(){
        return getAllCitiesFromWebSocket();
    }

    public City createCity(City city){
        city = cityRepository.save(city);
        getAllCitiesFromWebSocket();
        return city;
    }
}
