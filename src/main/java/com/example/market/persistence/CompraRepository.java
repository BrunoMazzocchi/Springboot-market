package com.example.market.persistence;

import com.example.market.domain.*;
import com.example.market.domain.repository.*;
import com.example.market.persistence.crud.*;
import com.example.market.persistence.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository //Interactua con la base de datos
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return null;
    }

    @Override
    public Optional<List<Purchase>> getByCliente(String clientId) {
        return Optional.empty();
    }

    @Override
    public Purchase save(Purchase purchase) {
        return null;
    }
}
