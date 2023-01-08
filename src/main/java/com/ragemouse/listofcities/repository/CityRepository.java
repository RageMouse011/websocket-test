package com.ragemouse.listofcities.repository;

import com.ragemouse.listofcities.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    List<City> findAll();
}
