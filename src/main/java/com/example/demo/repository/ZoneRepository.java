package com.example.demo.repository;

import com.example.demo.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ZoneRepository extends JpaRepository<Zone,Long> {
}
