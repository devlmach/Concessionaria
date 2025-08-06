package com.example.store.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.example.store.Dto.ProductRecordDto;
import com.example.store.Models.ProductModel;
import com.example.store.Repositories.ProductRepository;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") Long id) {
    Optional<ProductModel> product0 = productRepository.findById(id);

        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id) {
        Optional<ProductModel> product0 = productRepository.findById(id);

        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        productRepository.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }

    @PostMapping("/products")
    @Transactional
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") Long id, @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> product0 = productRepository.findById(id);

        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }

        var productModel = product0.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }


    //teste

    //teste 2

}
