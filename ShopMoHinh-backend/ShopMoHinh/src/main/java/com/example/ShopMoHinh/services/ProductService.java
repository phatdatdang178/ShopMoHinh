package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.Repositories.CategoryRepository;
import com.example.ShopMoHinh.Repositories.ProductImageRepository;
import com.example.ShopMoHinh.Repositories.ProductRepository;
import com.example.ShopMoHinh.dtos.ProductDTO;
import com.example.ShopMoHinh.dtos.ProductImageDTO;
import com.example.ShopMoHinh.exceptions.DataNotFoundException;
import com.example.ShopMoHinh.exceptions.InvalidParamException;
import com.example.ShopMoHinh.models.Category;
import com.example.ShopMoHinh.models.Product;
import com.example.ShopMoHinh.models.ProductImage;
import com.example.ShopMoHinh.responses.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements iProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;
    @Override
    public Product createProduct(ProductDTO productDTO) throws Exception {
        Category existingCategory = categoryRepository
                .findById(productDTO.getCategoryId())
                .orElseThrow(() -> new DataNotFoundException(
                        "Category not found with id"+productDTO.getCategoryId()));
        Product newProduct = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .thumbnail(productDTO.getThumbnail())
                .category(existingCategory)
                .build();
        return productRepository.save(newProduct);
    }

    @Override
    public Product getProductById(long productId) throws Exception {
        return productRepository.findById(productId)
                .orElseThrow(() -> new DataNotFoundException("Cannot find the product with id"+productId));
    }

    @Override
    public Page<ProductResponse> getAllProducts(PageRequest pageRequest) {

        return productRepository
                .findAll(pageRequest)
                .map(ProductResponse::fromProduct);
    }

    @Override
    public Product updateProduct(long id, ProductDTO productDTO) throws Exception {
        Product existingproduct = getProductById(id);
        if (existingproduct != null) {
            Category existingCategory = categoryRepository
                    .findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new DataNotFoundException(
                            "Category not found with id"+productDTO.getCategoryId()));
            existingproduct.setName(productDTO.getName());
            existingproduct.setCategory(existingCategory);
            existingproduct.setPrice(productDTO.getPrice());
            existingproduct.setDescription(productDTO.getDescription());
            existingproduct.setThumbnail(productDTO.getThumbnail());
            return productRepository.save(existingproduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(productRepository::delete);
    }

    @Override
    public boolean existsByName(String name) {

        return productRepository.existsByName(name);
    }
    @Override
    public ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws Exception {
        Product existingProduct = productRepository
                .findById(productId)
                .orElseThrow(() -> new DataNotFoundException(
                        "Product not found with id"+productImageDTO.getProductId()));
        ProductImage newProductImage = ProductImage.builder()
                .product(existingProduct)
                .imageUrl(productImageDTO.getImageUrl())
                .build();
        //Ko cho them qua 5 anh cho 1 san pham
        int size = productImageRepository.findByProductId(productId).size();
        if (size >= ProductImage.MAXIMUM_IMAGES_PER_PRODUCT) {
            throw new InvalidParamException(
                    "Number of images must be <= "
            +ProductImage.MAXIMUM_IMAGES_PER_PRODUCT    );
        }
        return productImageRepository.save(newProductImage);
    }
}
