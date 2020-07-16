package com.carrent.dao.repository;

import com.carrent.dao.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    Car findCarById(Long id);
    void delete(Long id);
}
