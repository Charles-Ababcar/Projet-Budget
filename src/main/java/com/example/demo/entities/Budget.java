package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Budget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private int annee;
    private Double montant;
    private Double montant_propose_bureau;
    private Double montant_propose_drp;
    private Double montant_execute;
    @JsonIgnore
    @OneToMany(mappedBy = "budget")
    private Collection<SuiviBudget> SuiviBudgets;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="idStructure", referencedColumnName = "id")
    private Structure structure;
    @JsonIgnore
    @OneToMany(mappedBy = "budget")
    //changer récement
    private Collection<LigneBudgetaire> LigneBudgetaires;

}
