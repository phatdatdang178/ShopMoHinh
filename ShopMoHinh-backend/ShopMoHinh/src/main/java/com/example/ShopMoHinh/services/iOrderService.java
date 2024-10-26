package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.dtos.OrderDTO;
import com.example.ShopMoHinh.models.Order;

import java.util.List;

public interface iOrderService {
    Order createOrder(OrderDTO orderDTO) throws Exception;
    Order getOrder(Long id);
    Order updateOrder(Long id, OrderDTO orderDTO) throws Exception;
    void deleteOrder(Long id);
    List<Order> findByUserId(Long userId);
}
