package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
.
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {
    //Information d'un utilisateur
    @Query(value = "SELECT * FROM structure AS s " +
            " LEFT JOIN user AS u ON u.id_structure=s.id " +
            " LEFT JOIN role AS r ON u.idrole=r.id " +
            " WHERE u.username=:username ",nativeQuery = true)
    //public Collection<User> findUserByUsername();
    public Collection<User> findUserByUsername(@Param("username")String username);
}
