package com.example.demo.controller;

import com.example.demo.dto.EtudiantPrenomNomDateNaissanceDto;
import com.example.demo.dto.EtudiantPrenomNomDto;
import com.example.demo.dto.EtudiantPrenomNomTelephoneDto;
import com.example.demo.entity.EtudiantEntity;
import com.example.demo.service.IEtudiantService;
import com.example.demo.mapper.EtudiantMapperDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EtudiantController {

        @Autowired
        IEtudiantService iEtudiantService;

        @GetMapping("/")
        public ResponseEntity<List<EtudiantEntity>> getAllEtudiants() {
                return new ResponseEntity<>(iEtudiantService.findAll(), HttpStatus.OK);
        }


        @GetMapping("/etudiant")
        public ResponseEntity<EtudiantEntity> getEtudiantByIdFromQuery(@RequestParam("id") long id) {
            Optional<EtudiantEntity> etudiantData = iEtudiantService.findById(id);

            if (etudiantData.isPresent()) {
                return new ResponseEntity<>(etudiantData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

    @GetMapping("/etudiant/nomprenom")
    public ResponseEntity<EtudiantPrenomNomDto> getEtudiantPrenomNomByIdFromQuery(@RequestParam("id") long id) {
        Optional<EtudiantEntity> etudiantData = iEtudiantService.findById(id);

        if (etudiantData.isPresent()) {
            return new ResponseEntity<>(new EtudiantMapperDto().toEtudiantPrenomNomDto(etudiantData.get()), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/etudiant/nomprenomtelephone")
    public ResponseEntity<EtudiantPrenomNomTelephoneDto> getEtudiantPrenomNomTelephoneByIdFromQuery(@RequestParam("id") long id) {
        Optional<EtudiantEntity> etudiantData = iEtudiantService.findById(id);

        if (etudiantData.isPresent()) {
            return new ResponseEntity<>( new EtudiantMapperDto().toEtudiantPrenomNomTelephoneDto(etudiantData.get()), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/etudiant/nomprenomdatenaissance")
    public ResponseEntity<EtudiantPrenomNomDateNaissanceDto> getEtudiantPrenomNomDateNaissanceByIdFromQuery(@RequestParam("id") long id) {
        Optional<EtudiantEntity> etudiantData = iEtudiantService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        if (etudiantData.isPresent()) {
            return new ResponseEntity<>(modelMapper.map(etudiantData.get(),EtudiantPrenomNomDateNaissanceDto.class), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new EtudiantPrenomNomDateNaissanceDto(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/etudiant/updatebyid")
    public ResponseEntity<EtudiantEntity> updtateEtudiantById(@RequestParam("id") long id
    , @RequestParam("nom") String nom
    , @RequestParam("prenom") String prenom
    ) throws ParseException {
       Optional<EtudiantEntity> etudiantEntity = iEtudiantService.update(id,nom,prenom);
       if (etudiantEntity.isPresent()) {
           return new ResponseEntity<>(etudiantEntity.get(), HttpStatus.OK);
       } else {
           return ResponseEntity.notFound().build();
       }
    }

    @PostMapping("/etudiant/createEtudiant")
    public ResponseEntity<EtudiantEntity> createEtudiant(@RequestParam("nom") String nom
            , @RequestParam("prenom") String prenom
            , @RequestParam("telephone") String telephone
            , @RequestParam("dateNaissance") String dateNaissance
    ) throws ParseException {
        Optional<EtudiantEntity> etudiantEntity = iEtudiantService.saveAndFlush(prenom, nom, dateNaissance, telephone);
        if (etudiantEntity.isPresent()) {
            return new ResponseEntity<>(etudiantEntity.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

}
