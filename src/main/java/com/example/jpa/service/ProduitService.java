package com.example.jpa.service;


import com.example.jpa.model.Produit;
import com.example.jpa.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired // initialiser repository
    private ProduitRepository repository;

//    public Produit save(Produit produit) throws Exception{
//        if (produit.getId() <= 0){
//            throw new Exception("Il y a … de produit");
//        }
//        return repository.save(produit);
//    }

    public List<Produit> findAll() {
        return repository.findAll();
    }

    public Optional<Produit> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Produit save(Produit produit) {
        return repository.save(produit);
    }

}
