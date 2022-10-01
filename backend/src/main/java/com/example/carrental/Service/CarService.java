package com.example.carrental.Service;

import com.example.carrental.Model.Cars;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Cars> getAllCar();
    Optional<Cars> getCarById(Long id);
    void addCar(Cars car);
    boolean  deleteCar(Long id);
    Cars updateCar (Long id, Cars car);
}
