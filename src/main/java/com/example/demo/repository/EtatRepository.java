package com.example.demo.repository;

import com.example.demo.entities.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EtatRepository extends JpaRepository<Etat,Long> {
}
