package com.felipe.product.api.controller;

import com.felipe.product.domain.entity.Product;
import com.felipe.product.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "product")
    public ResponseEntity<List<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "product/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "product")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "product/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "product/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id , @RequestBody Product product){
        return new ResponseEntity<>(productService.update(id, product), HttpStatus.OK);
    }
}
