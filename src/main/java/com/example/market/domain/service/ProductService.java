package com.example.market.domain.service;

import com.example.market.domain.*;
import com.example.market.domain.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service //Define que es un servicio
public class ProductService {
    //Inyecta el productRepository
    @Autowired //Genera un product repository
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity, int active){
        return productRepository.getScarseProducts(quantity, active);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    //Delete retornara un boolean si se puede eliminar o no
    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
