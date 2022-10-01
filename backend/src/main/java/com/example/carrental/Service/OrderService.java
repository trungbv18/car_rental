package com.example.carrental.Service;

import com.example.carrental.Model.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Orders> getAllOrder();
    public Optional<Orders> getOrderById(Long id);
    void addOrder(Orders order);
    public boolean  deleteOrder(Long id);
    public Orders updateOrderStatus (Long id, Orders order);
}
