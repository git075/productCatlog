package dev.anurag.ProductCatlog.service;

import dev.anurag.ProductCatlog.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {
    ProductEntity addProduct(ProductEntity product);
    Page<ProductEntity> getAllProductsPaginated(Pageable pageable);

    ProductEntity getProductById(Long id);
    ProductEntity updateProduct(Long id, ProductEntity updatedProduct);
    boolean deleteProduct(Long id);
    List<ProductEntity> searchByCategory(String category);
    List<ProductEntity> searchByName(String name);
}
