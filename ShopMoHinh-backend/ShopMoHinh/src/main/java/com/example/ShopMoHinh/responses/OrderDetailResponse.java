package com.example.ShopMoHinh.responses;

import com.example.ShopMoHinh.models.Order;
import com.example.ShopMoHinh.models.OrderDetail;
import com.example.ShopMoHinh.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailResponse {
    private Long id;


    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("product_id")
    private Product productId;

    @JsonProperty("price")
    private double price;

    @JsonProperty("number_of_product")
    private int numberOfProducts;

    @JsonProperty("total_money")
    private Float totalMoney;

    public static OrderDetailResponse fromOrderDetail(OrderDetail orderDetail) {
        return OrderDetailResponse
                .builder()
                .id(orderDetail.getId())
                .orderId(orderDetail.getOrder().getId())
                .productId(orderDetail.getProduct())
                .price(orderDetail.getPrice())
                .numberOfProducts(orderDetail.getNumberOfProducts())
                .totalMoney(orderDetail.getTotalMoney())
                .build();
    }
}
