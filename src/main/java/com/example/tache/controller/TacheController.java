package com.example.tache.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.tache.Entity.Taches;
import com.example.tache.service.*;

@RestController 
@RequestMapping("/api/taches")
public class TacheController {
    
    private final TacheService service;

    public TacheController(TacheService service) {
        this.service = service;
    }
    
    @PostMapping/*creer uen tache et envoyer le statut */
    public ResponseEntity<Taches> create(@RequestBody Taches tache){
        // Correction ici : .body() avec un "b" minuscule
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(tache));
    }
    
    @GetMapping /*afficher toutes les taches ou une taches specifique (en fonction du stratut) */
    public List<Taches> ReadsTaches(@RequestParam(required=false) Taches.Statut statut){
        return service.Reads(statut);
    }
    /*affiche tache en fonction de son id  */
    @GetMapping("/{id}")
    public Taches redtache(@PathVariable Long id ){
        return service.readbyid(id);
    }
    /*modifier une tache a partir de son id */
    @PutMapping("/{id}")
    public Taches updateTaches(@PathVariable Long id , @RequestBody Taches donnees){
       return  service.update(donnees, id);
    }
    /*supprimer une tache */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleTache(@PathVariable Long id){
        service.Delete(id);
        return ResponseEntity.noContent().build();
    }
}
