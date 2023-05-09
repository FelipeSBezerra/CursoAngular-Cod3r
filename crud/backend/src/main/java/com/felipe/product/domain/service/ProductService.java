package com.felipe.product.domain.service;

import com.felipe.product.domain.entity.Product;
import com.felipe.product.domain.exception.ResourceNotFoundException;
import com.felipe.product.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product findById(Integer id){
        try {
            return productRepository.findById(id).get();
        } catch (NoSuchElementException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Integer id){
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException(id);
        }
    }

    public Product update(Integer id, Product product){
        if(productRepository.existsById(id)) {
            Product productInDataBase = productRepository.getReferenceById(id);
            updateData(product, productInDataBase);
            return productRepository.save(productInDataBase);
        }
        throw new ResourceNotFoundException(id);
    }

    private void updateData(Product product, Product productInDataBase) {
        productInDataBase.setName(product.getName());
        productInDataBase.setPrice(product.getPrice());
    }

}
