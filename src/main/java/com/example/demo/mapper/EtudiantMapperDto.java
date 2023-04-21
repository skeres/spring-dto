package com.example.demo.mapper;

import com.example.demo.dto.EtudiantPrenomNomDto;
import com.example.demo.dto.EtudiantPrenomNomTelephoneDto;
import com.example.demo.entity.EtudiantEntity;

/**
 * Cette classe contient toutes les méthodes qui permettent de transformer un objet Etudiant
 * en un Etudiant...dto quelconque.
 */
public class EtudiantMapperDto {

    public EtudiantPrenomNomDto toEtudiantPrenomNomDto(EtudiantEntity etudiantEntity) {
        return  EtudiantPrenomNomDto.builder()
                .prenom(etudiantEntity.getPrenom())
                .nom((etudiantEntity.getNom()))
                .build();
    }

    public EtudiantPrenomNomTelephoneDto toEtudiantPrenomNomTelephoneDto(EtudiantEntity etudiantEntity) {
        return   EtudiantPrenomNomTelephoneDto.builder()
                .prenom(etudiantEntity.getPrenom())
                .nom((etudiantEntity.getNom()))
                .telephone((etudiantEntity.getTelephone()))
                .build();
    }
}
