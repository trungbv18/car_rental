package com.example.carrental.Service;

import com.example.carrental.Model.CarImages;
import com.example.carrental.Model.Cars;
import com.example.carrental.Repository.CarImgRepository;
import com.example.carrental.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CarImgSerImpl implements CarImgService {
    @Autowired
    CarImgRepository carImgRepository;

    @Override
    public List<CarImages> getByCarId(Long id) {

        return carImgRepository.findByCarId(id);
    }

    @Override
    public List<CarImages> getAll() {
        return carImgRepository.findAll();
    }
}
