package com.example.carrental.Service;

import com.example.carrental.Model.Cars;
import com.example.carrental.Model.Orders;
import com.example.carrental.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Orders> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addOrder(Orders order) {
        orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(Long id) {
        return false;
    }

    @Override
    public Orders updateOrderStatus(Long id, Orders order) {
        Optional<Orders> oldOrder = orderRepository.findById(id);
        if (oldOrder.isPresent()){
            Orders _oldOrder = oldOrder.get();
            _oldOrder.setRentalStatusId(order.getRentalStatusId());
            return orderRepository.save(_oldOrder);
        }
        return null;
    }
}
