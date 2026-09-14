package com.example.tache.Entity;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "taches")
public class Taches {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String titre;
    private  String description;
    @Enumerated(EnumType.STRING)
    private  Statut statut= Statut.A_FAIRE;
    public Statut getStatut() {
        return statut;
    }
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    private LocalDateTime dateCreation = LocalDateTime.now();
    public enum Statut {
        A_FAIRE, EN_COURS, TERMINEE
        
    }
    public Taches(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
    public Taches(){
        
    }
}
