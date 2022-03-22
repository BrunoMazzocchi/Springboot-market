package com.example.market.domain.repository;

import com.example.market.domain.*;

import java.util.*;

public interface PurchaseRepository {
    List<Purchase> getAll(); //Muestra las compras
    Optional<List<Purchase>> getByCliente(String clientId); //Muestra quien hizo la compra por el ID del cliente
    Purchase save(Purchase purchase); //Guarda una compra
}
