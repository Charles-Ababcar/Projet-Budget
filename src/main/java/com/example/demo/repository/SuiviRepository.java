package com.example.demo.repository;

import com.example.demo.entities.Suivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SuiviRepository extends JpaRepository<Suivi,Long> {
}
