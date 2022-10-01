package com.example.carrental.Service;

import com.example.carrental.Model.CarImages;
import com.example.carrental.Model.Cars;

import java.util.List;
import java.util.Optional;

public interface CarImgService {
    List<CarImages> getAll();
    List<CarImages> getByCarId(Long id);

}
