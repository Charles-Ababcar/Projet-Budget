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
public class Action implements Serializable {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private int version;
        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "etatActuel", nullable = false, referencedColumnName = "id")
        private Etat Etat;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "etatFinal", nullable = false, referencedColumnName = "id")
        private Etat Etat1;
        private String libelle;
        private int codeTypeAction;
        private String libelleAction;
    }



