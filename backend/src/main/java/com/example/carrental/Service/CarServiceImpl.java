package com.example.carrental.Service;

import com.example.carrental.Model.Cars;
import com.example.carrental.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Cars> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Cars> getCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void addCar(Cars car) {
        carRepository.save(car);
    }

    @Override
    public boolean deleteCar(Long id) {
        Optional<Cars> car = carRepository.findById(id);
        if (car.isPresent()) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Cars updateCar(Long id, Cars car) {
        Optional<Cars> oldCar = carRepository.findById(id);
        if (oldCar.isPresent()){
            Cars _oldCar = oldCar.get();
            _oldCar.setBrand(car.getBrand());
            _oldCar.setName(car.getName());
            _oldCar.setSeatNumber(car.getSeatNumber());
            _oldCar.setLicensePlates(car.getLicensePlates());
            _oldCar.setColor(car.getColor());
            _oldCar.setMainImage(car.getMainImage());
            _oldCar.setDescription(car.getDescription());
            _oldCar.setRentalPrice(car.getRentalPrice());
            return carRepository.save(_oldCar);
        }
        return null;
    }


}
