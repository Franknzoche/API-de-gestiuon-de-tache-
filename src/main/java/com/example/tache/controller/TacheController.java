package com.example.tache.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.tache.Entity.Taches;
import com.example.tache.service.*;

@RestController 
@RequestMapping("/api/taches")
public class TacheController {
    
    private final TacheService service;

    public TacheController(TacheService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<Taches> create(@RequestBody Taches tache){
        // Correction ici : .body() avec un "b" minuscule
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(tache));
    }
    
    @GetMapping 
    public List<Taches> ReadTaches(@RequestParam(required=false) Taches.Statut statut){
        return service.Reads(statut);
    }
}
