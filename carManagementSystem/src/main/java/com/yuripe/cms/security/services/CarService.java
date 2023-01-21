package com.yuripe.cms.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuripe.cms.exceptions.CarException;
import com.yuripe.cms.models.Car;
import com.yuripe.cms.repositories.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public Car getCar(String plate) throws CarException {
        return carRepository.findByPlate(plate).orElseThrow(() -> new CarException("Car Not FOUND!"));
    }

    public void addCar(Car car) {
        this.carRepository.save(car);
    }

    public void updateCar(String id, Car car) {
        this.carRepository.save(car);
    }

    public void deleteCar(String plate) {
        this.carRepository.deleteByPlate(plate);;
    }
}
