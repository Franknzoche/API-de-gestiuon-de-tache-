package com.example.tache.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tache.Entity.Taches;

@Repository 
public interface TacheRepository extends JpaRepository<Taches , Long>{
    List<Taches>findByStatut(Taches.Statut statut); 

}
