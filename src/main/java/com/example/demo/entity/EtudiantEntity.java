package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;


@Entity //signifie que la classe doit être persistée. Crée une entité JPA
@Data // annotation Lombock qui génère les getters et les setters dans le byte code, mais pas dans le source. Pour plus de "visibilité".
@AllArgsConstructor   // annotation Lombock : crée un contructeur avec tous les paramètres
@NoArgsConstructor  // annotation Lombock : crée un contructeur SANS paramètres
public class EtudiantEntity {
    @Id // spécifie que l'attribut ci dessous est la primaryKey de l'entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // type auto incrément
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String telephone;

    @Column(name = "dateCreation", updatable = false, columnDefinition="timestamp default current_timestamp")
    private Date dateCreation;

    public EtudiantEntity(Long id, String nom, String prenom, Date dateNaissance, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
    }
}
