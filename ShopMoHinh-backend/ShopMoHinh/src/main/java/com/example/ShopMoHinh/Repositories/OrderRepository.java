package com.example.ShopMoHinh.Repositories;

import com.example.ShopMoHinh.models.Order;
import com.example.ShopMoHinh.models.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);

}
