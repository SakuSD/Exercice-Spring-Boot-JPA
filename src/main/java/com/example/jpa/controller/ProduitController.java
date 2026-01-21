package com.example.jpa.controller;

import com.example.jpa.model.Produit;
import com.example.jpa.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Affiche la liste des produits
    @GetMapping("/")
    public String listeProduits(Model model) {
        model.addAttribute("produits", produitService.findAll());
        return "index"; // vue Thymeleaf
    }

    // Affiche le formulaire d'ajout
    @GetMapping("/nouveau")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("produit", new Produit());
        return "formulaire-produit";
    }

    // Enregistre un nouveau produit
    @PostMapping("/enregistrer")
    public String enregistrerProduit(@ModelAttribute Produit produit) {
        produitService.save(produit);
        return "redirect:/";
    }

    // Affiche le formulaire de modification
    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable("id") Long id, Model model) {
        Optional<Produit> produit = produitService.findById(id);
        if (produit.isPresent()) {
            model.addAttribute("produit", produit.get());
            return "formulaire-produit";
        } else {
            return "redirect:/";
        }
    }

    // Met à jour le produit
    @PostMapping("/modifier/{id}")
    public String modifierProduit(@PathVariable("id") Long id, @ModelAttribute Produit produit) {
        produit.setId(id);
        produitService.save(produit);
        return "redirect:/";
    }

    // Supprime un produit
    @GetMapping("/supprimer/{id}")
    public String supprimerProduit(@PathVariable("id") Long id) {
        produitService.deleteById(id);
        return "redirect:/";
    }
}
