package com.example.carrental.Controller;

import com.example.carrental.Model.CarImages;
import com.example.carrental.Service.CarImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/car-images")
public class CarImgController {
    @Autowired
    CarImgService carImgService;
    @GetMapping("/get-all")
    public ResponseEntity<List<CarImages>> getAll(){
        List<CarImages> carImages = carImgService.getAll();
        if (carImages.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CarImages>>(carImages, HttpStatus.OK);
    }
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<List<CarImages>> getByCarId(@PathVariable("id") Long id){
        List<CarImages> carImages = carImgService.getByCarId(id);
        if (carImages.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<CarImages>>(carImages, HttpStatus.OK);
    }
}
