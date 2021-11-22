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
public class DRP implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int CODEJDE;
    private String adressedrp;
    private String nomdrp;
    private int telephonedrp;
    @OneToMany
    private Collection<Structure> structures;


    @OneToMany(mappedBy = "Drp")
    private Collection<Structure> structure;

    public Collection<Structure> getStructure() {
        return structure;
    }

    public void setStructure(Collection<Structure> structure) {
        this.structure = structure;
    }
}
