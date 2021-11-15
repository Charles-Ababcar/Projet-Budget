package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Decaissement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private String Commentaires;
    private Date date;
    private String libelle;
    private Double montant;
    private Double retenue;
    private Double TVAPaye;
    private String ninea;
    @Column(nullable = true, length = 64)
    private String justificatif;
    @JsonIgnore
    @OneToMany
    private Collection<Suivi> suivis;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idLigneBudgetaire", nullable = false, referencedColumnName = "id")
    private LigneBudgetaire ligneBudgetaires;

}
