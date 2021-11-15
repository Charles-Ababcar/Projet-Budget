package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneBudgetaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private Double montant;
    private Double montantExecute;
    private Double montantProposeBureau;
    private Double montantProposeDrp;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="idBudget", nullable = false, referencedColumnName = "id")
    private Budget budget;
    @ManyToOne
    @JoinColumn(name ="idCompteBudget", nullable = false, referencedColumnName = "id")
    private CompteBudget compteBudget;
}
