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
public class Structure implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String AdresseStructure;
    private int bureau;
    private int codeStructure;
    private String EMAIL;
    private String nomStructure;
    private int TelephoneStructure;
    private int codepostal;
    private int zone_id;
    private boolean noeud;
    private boolean noeudct;
    private String longitude;
    private String latitude;
    @JsonIgnore
    @OneToMany
    private Collection<Budget> Budgets;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="idDrp", referencedColumnName = "id")
    private DRP Drp;

    @JsonIgnore
    @OneToMany(mappedBy = "structure")
    private Collection<Budget> Budget;

    @JsonIgnore

    public Collection<Budget> getBudget() {
        return Budget;
    }

    public void setBudget(Collection<Budget> dbBudget) {
        this.Budget = dbBudget;
    }
}
