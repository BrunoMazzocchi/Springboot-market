package com.example.market.web.controller;

import com.example.market.domain.*;
import com.example.market.domain.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController //Controller de una API Rest
@RequestMapping("/products")//Define por donde se pasan los datos
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/byCategory/{categoryId}")
    public Optional<List<Product>> getByCategoryId(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity, int active){
        return productService.getScarseProducts(quantity, active);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id")  int prodctId){
        return productService.delete(prodctId);
    }
}
