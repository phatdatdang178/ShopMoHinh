package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.Repositories.OrderDetailRepository;
import com.example.ShopMoHinh.Repositories.OrderRepository;
import com.example.ShopMoHinh.Repositories.ProductRepository;
import com.example.ShopMoHinh.dtos.OrderDetailDTO;
import com.example.ShopMoHinh.exceptions.DataNotFoundException;
import com.example.ShopMoHinh.models.Order;
import com.example.ShopMoHinh.models.OrderDetail;
import com.example.ShopMoHinh.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class OrderDetailService implements iOrderDetailService{
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    @Override
    public OrderDetail createOrderDetail(OrderDetailDTO orderDetailDTO) throws Exception {
        Order order = orderRepository.findById(orderDetailDTO.getOrderId())
                .orElseThrow(()->new DataNotFoundException(
                        "Cannot find Order with id "+orderDetailDTO.getOrderId()));

        Product product = productRepository.findById(orderDetailDTO.getProductId())
                .orElseThrow(()->new DataNotFoundException(
                        "Cannot find Product with id "+orderDetailDTO.getProductId()));
        OrderDetail orderDetail = OrderDetail.builder()
                .order(order)
                .product(product)
                .numberOfProducts(orderDetailDTO.getNumberOfProducts())
                .price(orderDetailDTO.getPrice())
                .totalMoney(orderDetailDTO.getTotalMoney())
                .build();
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail getOrderDetail(Long id) throws DataNotFoundException {
        return orderDetailRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Cannot find"+id));
    }

    @Override
    public OrderDetail updateOrderDetail(Long id, OrderDetailDTO orderDetailDTO)
            throws DataNotFoundException {
        OrderDetail existingOrderDetail  = orderDetailRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Cannot find "+id));
        Order existingOrder = orderRepository.findById(orderDetailDTO.getOrderId())
                .orElseThrow(()-> new DataNotFoundException("Cannot find "+id));
        Product existingProduct = productRepository.findById(orderDetailDTO.getProductId())
                .orElseThrow(()->new DataNotFoundException(
                        "Cannot find Product with id "+orderDetailDTO.getProductId()));
        existingOrderDetail.setPrice(orderDetailDTO.getPrice());
        existingOrderDetail.setNumberOfProducts(orderDetailDTO.getNumberOfProducts());
        existingOrderDetail.setTotalMoney(orderDetailDTO.getTotalMoney());
        existingOrderDetail.setOrder(existingOrder);
        existingOrderDetail.setProduct(existingProduct);
        return orderDetailRepository.save(existingOrderDetail);
    }

    @Override
    public void deleteById(Long id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public List<OrderDetail> findByOrderId(Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }
}
