package com.example.ShopMoHinh.dtos;

import com.example.ShopMoHinh.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImageDTO {

    @JsonProperty("product_id")
    @Min(value = 1,message = "Product's ID must be >0")
    private Long productId;

    @Size(min = 5,max = 200,message = "Image's name")
    @JsonProperty("image_url")
    private String imageUrl;
}
