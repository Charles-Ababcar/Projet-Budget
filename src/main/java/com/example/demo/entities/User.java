package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private boolean account_expired;
    private boolean account_locked;
    private boolean enabled;
    private String password;
    private boolean password_expired;
    private String username;
    private String fullname;
    @ManyToOne
    @JoinColumn(name ="idStructure", referencedColumnName = "id")
    private Structure structure;
    private int idrole;
    private boolean affectecaisse;
    private boolean passwordtochange;
    private int partenaire;
}
