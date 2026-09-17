package main.java.com.example.tache.controller;
import java.net.ResponseCache;
import java.net.Authenticator.RequestorType;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tache.Entity.Taches;
import com.example.tache.service.*;

@RestController 
@RequestMapping("/api/taches")
public class TacheController {
    private final TacheService service ;

    public TacheController(TacheService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Taches> create(@RequestBody Taches tache){
        return ResponseEntity.status(HttpStatus.CREATED).Body(service.create(tache));
    }
    @GetMapping 
    /*required=false c'est pour ne pas obliger le client a fournir le statut  avant que l'on ne l'affiche la liste de tout les status
    donc si le client passe un statut ( a faiire , terminee....) on l'affiche cette liste de statut la si non on affiches tous  
    */
    public List<Taches> ReadTaches(@RequestParam(required=false) Taches.Statut statut){
        return service.Reads(statut);
    }
    
}


