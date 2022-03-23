package com.example.market.persistence.crud;

import com.example.market.persistence.entity.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
