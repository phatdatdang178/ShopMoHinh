package com.example.ShopMoHinh.Repositories;

import com.example.ShopMoHinh.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage,Long> {
    List<ProductImage> findByProductId(Long productId);
}
