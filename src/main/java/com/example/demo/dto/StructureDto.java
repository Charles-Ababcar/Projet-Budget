package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class StructureDto {
        private Long idStructure;
        private Long idDrp;
        private String AdresseStructure;
        private int bureau;
        private Long codeStructure;
        private String EMAIL;
        private String nomStructure;
        private Long TelephoneStructure;
        private Long codepostal;
        private int zone_id;
        private boolean noeud;
        private boolean noeudct;
        private Long longitude;
        private Long latitude;
    }


