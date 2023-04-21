package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * Cette classe illustre une classe et son builder construit à la main. elle contient
 * - 1 méthode static EtudiantPrenomNomTelephoneDtoBuilder qui retourne une instance d'une classe
 * EtudiantPrenomNomTelephoneDtoBuilder, static aussi, qui reprend les mêmes attributs que
 * EtudiantPrenomNomTelephoneDto
 * - 1 classe static EtudiantPrenomNomTelephoneDtoBuilder qui contient :
 *  a/ les mêmes attributs
 *  b/ des setters qui retourne l'instance en cours
 *  c/ 1 méthode "build" qui construit EtudiantPrenomNomTelephoneDto à partir de EtudiantPrenomNomTelephoneDtoBuilder
 */
public class EtudiantPrenomNomTelephoneDto {
    private String nom;
    private String prenom;
    private String telephone;

   /**
     * this builder has been write by hand
     *
     */

    // STATIC method generate an intermediate class EtudiantPrenomNomDtoBuilder
    public static EtudiantPrenomNomTelephoneDtoBuilder builder() {
        return new EtudiantPrenomNomTelephoneDtoBuilder(); }

    // STATIC class used to
    public static class EtudiantPrenomNomTelephoneDtoBuilder {
        private String nom;
        private String prenom;
        private String telephone;

        public EtudiantPrenomNomTelephoneDtoBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public EtudiantPrenomNomTelephoneDtoBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public EtudiantPrenomNomTelephoneDtoBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public EtudiantPrenomNomTelephoneDto build() {
            return new EtudiantPrenomNomTelephoneDto(this.nom, this.prenom, this.telephone);
        }

    }
}
