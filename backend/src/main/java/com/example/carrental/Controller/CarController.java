package com.example.carrental.Controller;

import com.example.carrental.Model.Cars;
import com.example.carrental.Repository.CarRepository;
import com.example.carrental.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService carService;
//    @Autowired
//    CarRepository carRepository;
//    @GetMapping("/get")
//    public ResponseEntity<List<Cars>> get(){
//        List<Cars> carList = carRepository.showAllCars();
//        if (carList.isEmpty()){
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Cars>>(carList, HttpStatus.OK);
//    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Cars>> getAllCar(){
        List<Cars> carList = carService.getAllCar();
        if (carList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cars>>(carList, HttpStatus.OK);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Cars> getCarById(@PathVariable("id") Long id){
        Optional<Cars> car = carService.getCarById(id);
        if (car.isPresent()){
            return new ResponseEntity<>(car.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Cars> addCar (@RequestBody Cars car) {
        try {
            carService.addCar(car);
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Cars> deleteCar(@RequestParam("id") long id) {
        boolean bl = carService.deleteCar(id);
        if (bl == true) {
                return new ResponseEntity<>(HttpStatus.OK);
        } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping ("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Cars> updateCar (@RequestParam("id") Long id,@RequestBody Cars car) {
        try {
            carService.updateCar(id,car);
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
