# Gestion des tâches

Application de gestion de tâches développée en Java avec Spring Boot et PostgreSQL.

## Description
Cette application permet de gérer des tâches professionnelles avec les fonctionnalités suivantes :
- créer une tâche
- lister toutes les tâches
- filtrer par statut
- récupérer une tâche par son identifiant
- modifier une tâche
- supprimer une tâche

## Stack technique
- Java 24
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

## Prérequis
- Java 21 ou plus
- PostgreSQL
- Maven

## Installation
1. Cloner le projet
2. Créer une base PostgreSQL nommée `tache_db`
3. Copier le fichier d’exemple de configuration :
   ```bash
   cp src/main/resources/application-postgres.example.properties src/main/resources/application-postgres.properties