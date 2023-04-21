package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Cette classe illustre qu'on peut se passer de builder. La mapping de Etudiant vers les Etudiants...dto
 * se fait grace à l'artifact <artifactId>modelmapper</artifactId>
 */
public class EtudiantPrenomNomDateNaissanceDto {
    private String nom;
    private String prenom;
    private Date dateNaissance;



}
