package com.example.demo.repository;

import com.example.demo.entities.DRP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DRPRepository extends JpaRepository<DRP,Long> {
}
