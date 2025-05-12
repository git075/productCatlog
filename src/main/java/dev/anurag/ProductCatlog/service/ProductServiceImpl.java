package dev.anurag.ProductCatlog.service;

import dev.anurag.ProductCatlog.entity.ProductEntity;
import dev.anurag.ProductCatlog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;



    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @CacheEvict(value = {"products", "product"}, allEntries = true)
    public ProductEntity addProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    @Cacheable("products")
    public Page<ProductEntity> getAllProductsPaginated(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    @Cacheable(value = "product", key = "#id")
    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + id));
    }

    @Override
    @CacheEvict(value = {"products", "product"}, allEntries = true)
    public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
        ProductEntity existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setPrice(updatedProduct.getPrice());
        existing.setCategory(updatedProduct.getCategory());
        return productRepository.save(existing);
    }

    @Override
    @CacheEvict(value = {"products", "product"}, allEntries = true)
    public boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ProductEntity> searchByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category);
    }

    @Override
    public List<ProductEntity> searchByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
