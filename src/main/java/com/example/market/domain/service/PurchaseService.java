package com.example.market.domain.service;

import com.example.market.domain.*;
import com.example.market.domain.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository  purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }


    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseRepository.getByCliente(clientId);
    }
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
