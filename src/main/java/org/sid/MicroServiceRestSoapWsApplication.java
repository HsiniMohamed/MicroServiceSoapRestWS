package org.sid;

import java.util.Date;

import org.sid.entities.Compte;
import org.sid.entities.TypeCompte;
import org.sid.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MicroServiceRestSoapWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceRestSoapWsApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CompteRepository compteRepository,RepositoryRestConfiguration repositoryRestConfiguration) {
		return args->{
			//l'id est exposeé
			repositoryRestConfiguration.exposeIdsFor(Compte.class);
			
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.COURANT));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.COURANT));
			compteRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});

		};
	}

}
