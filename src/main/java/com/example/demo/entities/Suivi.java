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
public class Suivi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private String observations;
    private Date date;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Decaissement Decaissement;
    @ManyToOne
    @JoinColumn(name ="idEtat", referencedColumnName = "id")
    private Etat etat;
}
