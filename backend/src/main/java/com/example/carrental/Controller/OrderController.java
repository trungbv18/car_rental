package com.example.carrental.Controller;

import com.example.carrental.Model.Cars;
import com.example.carrental.Model.Orders;
import com.example.carrental.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Orders>> getAllCar(){
        List<Orders> orderList = orderService.getAllOrder();
        if (orderList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orders>>(orderList, HttpStatus.OK);
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Orders> addOrder (@RequestBody Orders order) {
        try {
            orderService.addOrder(order);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get-by-id/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER') ")
    public ResponseEntity<Orders> getOrderById(@PathVariable("id") Long id){
        Optional<Orders> order = orderService.getOrderById(id);
        if (order.isPresent()){
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping ("/update-status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Orders> updateOrderStatus (@RequestParam("id") Long id,@RequestBody Orders order) {
        try {
            orderService.updateOrderStatus(id,order);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
