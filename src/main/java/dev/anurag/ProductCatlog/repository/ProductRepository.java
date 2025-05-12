package dev.anurag.ProductCatlog.repository;

import dev.anurag.ProductCatlog.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByCategoryIgnoreCase(String category);
    List<ProductEntity> findByNameContainingIgnoreCase(String name);
}
