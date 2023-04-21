package com.example.demo.repository;

import com.example.demo.entity.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;


//@RepositoryRestResource        //Dit à Spring que les méthodes ci dessous doivent etre accessible
                               //via une API rest. Il faut donc définir la base de données
@Repository
 public interface IEtudiantRepository extends JpaRepository<EtudiantEntity,Long> {

    List<EtudiantEntity> findByPrenomAndNomAndDateNaissance(String prenom, String nom, Date dateNaissance);
}
