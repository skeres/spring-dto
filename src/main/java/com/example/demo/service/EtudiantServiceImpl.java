package com.example.demo.service;

import com.example.demo.entity.EtudiantEntity;
import com.example.demo.repository.IEtudiantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements  IEtudiantService{

    private static final Logger logger = LoggerFactory.getLogger(EtudiantServiceImpl.class);

    @Autowired
    IEtudiantRepository ietudiantRepository;

    @Override
    public List<EtudiantEntity> findAll() {
        return ietudiantRepository.findAll();
    }

    @Override
    public Optional<EtudiantEntity> findById(Long id) {
        return ietudiantRepository.findById(id);
    }

    @Override
    public Optional<EtudiantEntity> update(Long id,String nom,String prenom) throws ParseException {
        Optional<EtudiantEntity> existEtudiantEntity=findById(id);
        if (existEtudiantEntity.isPresent()) {
            EtudiantEntity etudiantEntity=existEtudiantEntity.get();
            etudiantEntity.setPrenom(prenom);
            etudiantEntity.setNom(nom);
            ietudiantRepository.save(etudiantEntity);
        }
            return existEtudiantEntity;
     }

    @Override
    public Optional<EtudiantEntity> saveAndFlush(String prenom, String nom, String dateNaissance, String telephone) throws ParseException {
        Date dtnaiss=new SimpleDateFormat("dd-MM-yyyy").parse(dateNaissance);
        List<EtudiantEntity> listEtudiantEntity=ietudiantRepository.findByPrenomAndNomAndDateNaissance(prenom, nom, dtnaiss);
        if (listEtudiantEntity.isEmpty()) {
            EtudiantEntity etudiantEntity=new EtudiantEntity();
            etudiantEntity.setPrenom(prenom);
            etudiantEntity.setNom(nom);
            etudiantEntity.setDateNaissance(new SimpleDateFormat("dd-MM-yyyy").parse(dateNaissance));
            etudiantEntity.setDateCreation(new Date());
            etudiantEntity.setTelephone(telephone);
            ietudiantRepository.saveAndFlush(etudiantEntity);
            return Optional.of(etudiantEntity);
        } else {
            logger.info(">>> Etudiant already exists in database : same prenom, nom, date de naissance");
            return Optional.empty();
        }

    }
}
