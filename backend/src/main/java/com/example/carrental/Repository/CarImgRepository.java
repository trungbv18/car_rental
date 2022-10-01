package com.example.carrental.Repository;

import com.example.carrental.Model.CarImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarImgRepository extends JpaRepository<CarImages, Long> {
    @Query("SELECT carImg FROM CarImages carImg where carImg.carId.carId = :id")
    List<CarImages> findByCarId(@Param("id") Long id);

}
