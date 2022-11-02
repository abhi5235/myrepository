package com.example.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Car;
import com.example.repo.CarRepository;

@Service
public class Carservice {
	@Autowired
	CarRepository carrepo;

	public Car addCarInDataBase(Car car) {
		System.out.println(carrepo.getClass());
		Car savedObj = carrepo.save(car);
		return savedObj;
	}

	public Car getCarDatafromDB(int id) {
		Optional<Car> OptionalCar = carrepo.findById(id);
		Car car = OptionalCar.get();
		return car;

	}

	@Transactional
	public String updateCarDatafromDB(Car car) {
		Optional<Car> optionalCar = carrepo.findById(car.getCid());
		if (optionalCar.isEmpty()) {
			return "Car " + car.getCid() + " is not avilable in databse";
		} else {
			Car carInDB = optionalCar.get();
			carInDB.setColour(carInDB.getColour());
			carInDB.setOwner_name(carInDB.getOwner_name());
			return "Car " + car.getCid() + " data is updated";
		}
	}

	public String deleteCarDatafromDB(int id) {
		if (carrepo.findById(id).isEmpty()) {
			return "Car data " + id + " is not present";
		} else {
			carrepo.deleteById(id);
			return "Car data " + id + " is deleted";
		}
	}

}
