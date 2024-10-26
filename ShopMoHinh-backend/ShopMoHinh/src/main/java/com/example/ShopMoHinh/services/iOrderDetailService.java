package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.dtos.OrderDetailDTO;
import com.example.ShopMoHinh.exceptions.DataNotFoundException;
import com.example.ShopMoHinh.models.OrderDetail;

import java.util.List;

public interface iOrderDetailService {
    OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) throws Exception;
    OrderDetail getOrderDetail(Long id) throws Exception;
    OrderDetail updateOrderDetail(Long id,OrderDetailDTO newOrderDetailData) throws DataNotFoundException;
    void deleteById(Long id);
    List<OrderDetail> findByOrderId(Long orderId);
}
