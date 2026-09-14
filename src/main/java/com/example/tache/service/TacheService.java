package com.example.tache.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.tache.Entity.*;;
import com.example.tache.repository.TacheRepository;

@Service 
public class TacheService {
  private final TacheRepository repository;

  public TacheService(TacheRepository repository) {
    this.repository = repository;
  }
 /*creer une tache  */
 public Taches create(Taches tache){
    return repository.save(tache);
 }
 /*lister toutes les taches (read), pour afficher les taches , on doit savoir le statut les taches seront afficher en fonc
 du statut donc en parametre on passe le statut d'ou Taches.statut statut */
 public List<Taches> Reads(Taches.Statut statut){
    if(statut != null){
        return repository.findByStatut(statut);
    }
    else{
        return repository.findAll();
    }
 }
 /*recuper une tache par son id : ici , si le findbyid(id) ne renvoi pas la tache , cela veut dire que la tache 
 n'existe pas et donc on utlise le orElseThrow pour lever une execption et l'afficher */
 public Taches read(Long id){
    return repository.findById(id).orElseThrow(() -> new RuntimeException(" Tache introuvable : " + id));
 }
}
