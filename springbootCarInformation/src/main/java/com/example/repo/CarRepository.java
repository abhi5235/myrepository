package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Car;
@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

}
