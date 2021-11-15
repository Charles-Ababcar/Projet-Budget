package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteBudget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private int bureau;
    private String libelle;
    private int numero;
    private int comptejde;
    @OneToMany()
    private Collection<LigneBudgetaire> ligneBudgetaires;


}
