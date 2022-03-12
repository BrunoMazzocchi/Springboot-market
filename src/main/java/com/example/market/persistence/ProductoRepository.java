package com.example.market.persistence;

import com.example.market.domain.*;
import com.example.market.domain.repository.*;
import com.example.market.persistence.crud.*;
import com.example.market.persistence.entity.*;
import com.example.market.persistence.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;

import java.util.*;
@EnableAutoConfiguration
@Repository //Interactua con la base de datos utilizando las operaciones.
public class ProductoRepository implements ProductRepository {
    @Autowired //Spring crea la instancia
    private ProductoCrudRepository productoCrudRepository;

    @Autowired //Solo se usa con componentes de Spring
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int idCategoria){
        List<Producto> productos = productoCrudRepository.findByIdCategoria(idCategoria);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity, int active){
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, active );
        return productos.map(prods -> mapper.toProducts((prods)));
    }

    @Override
    public Optional<Product> getProduct(int productId){
        return productoCrudRepository.findById(productId).map(producto ->  mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product){
        //Como se espera un producto, se tiene que convertir
        //Product to Producto y enviarlo
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId );
    }
}
