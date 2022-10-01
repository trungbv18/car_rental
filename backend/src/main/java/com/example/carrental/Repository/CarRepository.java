package com.example.carrental.Repository;

import com.example.carrental.Model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Cars, Long> {
    @Query("SELECT car FROM Cars car")
    List<Cars> showAllCars();
//    @Query("SELECT car FROM Cars car where car.car_id = :id")
//    Cars findCarById(@Param("id") Long id);
}
