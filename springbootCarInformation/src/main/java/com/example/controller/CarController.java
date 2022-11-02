package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Car;
import com.example.service.Carservice;

@RestController
public class CarController {
	@Autowired
	Carservice carservice;

	@PostMapping("/car")
	public Car addCar(@RequestBody Car car) {
		Car addedObj = carservice.addCarInDataBase(car);
		return addedObj;

	}

	@GetMapping("/car")
	public Car getCar(@PathVariable int id) {
		return carservice.getCarDatafromDB(id);

	}

	@PutMapping("car")
	public String updateCar(@RequestBody Car car) {
		return carservice.updateCarDatafromDB(car);
	}

	@DeleteMapping("car")
	public String deleteCar(@PathVariable int id) {
		String deleteCarDatafromDB = carservice.deleteCarDatafromDB(id);
		return deleteCarDatafromDB;
	}
}
