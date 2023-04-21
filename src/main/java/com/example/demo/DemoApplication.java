package com.example.demo;

import com.example.demo.entity.EtudiantEntity;
import com.example.demo.repository.IEtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication implements CommandLineRunner {

	private static final String DATE_FORMAT="dd-MM-yyyy";

	@Autowired  //permet d'injecter au runtime une implémentation de cette interface
	private IEtudiantRepository iEtudiantRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//implements CommandLineRunner permet de lancer des commandes spécifiques au demarrage de l'application.
	//exemple : insérer des données dans une table
	@Override
	//methode overide de CommandLineRunner
	public void run(String... args) throws Exception {


		iEtudiantRepository.save(new EtudiantEntity(null,"k","steph"
				,new SimpleDateFormat(DATE_FORMAT).parse("15-05-1964")
				,"0623252801"
				,null
		));
		iEtudiantRepository.save(new EtudiantEntity(null,"m","maria"
				,new SimpleDateFormat(DATE_FORMAT).parse("02-02-2002")
				,"0623252802"
				,null
		));
		iEtudiantRepository.save(new EtudiantEntity(null,"p","phil"
				,new SimpleDateFormat(DATE_FORMAT).parse("03-03-2003")
				,"0623252803"
				,null
		));
		iEtudiantRepository.save(new EtudiantEntity(null,"j","jessica"
				,new SimpleDateFormat(DATE_FORMAT).parse("04-04-2004")
				,"0623252804"
				,null
		));
		iEtudiantRepository.save(new EtudiantEntity(null,"z","jessica"
				,new SimpleDateFormat(DATE_FORMAT).parse("05-05-2005")
				,"0623252805"
				,null
		));

	}
}
