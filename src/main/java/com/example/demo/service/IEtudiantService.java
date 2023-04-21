package com.example.demo.service;

import com.example.demo.entity.EtudiantEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface IEtudiantService {

    List<EtudiantEntity> findAll();
    Optional<EtudiantEntity> findById(Long id);
    Optional<EtudiantEntity> update(Long id,String nom,String prenom) throws ParseException;
    Optional<EtudiantEntity> saveAndFlush(String prenom, String nom, String dateNaissance, String telephone) throws ParseException;
}
