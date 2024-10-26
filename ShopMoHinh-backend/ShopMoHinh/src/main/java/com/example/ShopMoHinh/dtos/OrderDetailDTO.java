package com.example.ShopMoHinh.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1,message = "Order's Id must be >0")
    private Long orderId;

    @JsonProperty("product_id")
    @Min(value = 1,message = "Product's Id must be >0")
    private Long productId;

    @JsonProperty("price")
    @Min(value = 0,message = "Price's  must be >0")
    private Float price;


    @JsonProperty("number_of_product")
    @Min(value = 1,message = "Number's Id must be >0")
    private int numberOfProducts;

    @JsonProperty("total_money")
    @Min(value = 0,message = "User's Id must be >= 0")
    private Float totalMoney;

}
