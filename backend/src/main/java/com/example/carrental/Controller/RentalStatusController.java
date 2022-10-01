package com.example.carrental.Controller;

import com.example.carrental.Model.Orders;
import com.example.carrental.Model.RentalStatus;
import com.example.carrental.Service.RentalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/rental-status")
public class RentalStatusController {
    @Autowired
    RentalStatusService rentalStatusService;
    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<RentalStatus>> getAllStatus(){
        List<RentalStatus> rentalStatus = rentalStatusService.getAllStatus();
        if (rentalStatus.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<RentalStatus>>(rentalStatus, HttpStatus.OK);
    }
}
