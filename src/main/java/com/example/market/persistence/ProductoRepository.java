package com.example.market.persistence;

import ch.qos.logback.core.pattern.parser.*;
import com.example.market.persistence.crud.*;
import com.example.market.persistence.entity.*;

import java.util.*;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List< Producto > getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad, int estado){
         return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, estado = 1);
    }
}
