package dev.anurag.ProductCatlog.controller;

import dev.anurag.ProductCatlog.entity.ProductEntity;
import dev.anurag.ProductCatlog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductControllerV2 {


    @Autowired
    private final ProductService productService;


    public ProductControllerV2(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Page<ProductEntity>> getAllProductsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> products = productService.getAllProductsPaginated(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
        ProductEntity product = productService.getProductById(id);
        if(product!=null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        Boolean deleted = productService.deleteProduct(id);
        if(deleted){
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductEntity>> searchProductByCategory(@PathVariable String category) {
        List<ProductEntity> productsByCategory = productService.searchByCategory(category);
        if(productsByCategory!=null){
            return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductEntity>> searchProductByName(@RequestParam String name) {
        List<ProductEntity> productsByName = productService.searchByName(name);
        if(productsByName!=null){
            return new ResponseEntity<>(productsByName, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}
