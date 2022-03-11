package com.example.market.persistence.crud;

import com.example.market.persistence.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

import java.util.*;

//Se extiende y pasa la tabla y el tipo del ID.
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    //Forma nativa
    @Query(value = "SELECT * from PRODUCTOS WHERE id_categoria = ?", nativeQuery = true)
    //Toda la lista que pertenezcan a una categoria en especifico
    List<Producto> findByIdCategoria(int idCategoria);


    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, int estado);

}
