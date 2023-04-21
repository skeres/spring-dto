package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
        private Long id;
        private String nom;
        private String prenom;
        private Date dateNaissance;
        private String telephone;
}
