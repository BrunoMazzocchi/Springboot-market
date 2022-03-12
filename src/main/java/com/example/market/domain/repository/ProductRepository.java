package com.example.market.domain.repository;

import com.example.market.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
//Metodos que cualquier repositorio que incluya producto tenga que implementar
public interface ProductRepository{
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarseProducts(int quantity, int active);

    Optional<Product> getProduct(int productId);
    Product save (Product product);
    void delete(int productId);
}
