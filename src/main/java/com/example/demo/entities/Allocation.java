package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private String Commentaires;
    private Date date;
    private boolean initiale;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idLigneBudgetaire", nullable = false, referencedColumnName = "id")
    private LigneBudgetaire lignebudgetaire;
    private Double montant;
}
