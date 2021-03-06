package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;

import java.util.List;

public interface CarService {

    void save(Car car);

    void delete(Long id);

    List<Car> findAll();

    Car getCarById(Long id);

    List<Car> findCarByCategory(Category category);

}
