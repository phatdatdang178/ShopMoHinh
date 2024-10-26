package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.dtos.ProductDTO;
import com.example.ShopMoHinh.dtos.ProductImageDTO;
import com.example.ShopMoHinh.models.Product;
import com.example.ShopMoHinh.models.ProductImage;
import com.example.ShopMoHinh.responses.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.ShopMoHinh.models.*;

public interface iProductService {
    Product createProduct(ProductDTO productDTO) throws Exception;

    Product getProductById(long id) throws Exception;

    Page<ProductResponse> getAllProducts(PageRequest pageRequest);

    Product updateProduct(long id, ProductDTO productDTO) throws Exception;

    void deleteProduct(long id);

    boolean existsByName(String name);

    ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws Exception;
}
