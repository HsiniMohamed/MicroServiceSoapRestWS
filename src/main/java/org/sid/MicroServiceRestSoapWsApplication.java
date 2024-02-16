package org.sid;

import java.util.Date;

import org.sid.entities.Client;
import org.sid.entities.Compte;
import org.sid.entities.TypeCompte;
import org.sid.repositories.ClientRepository;
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
	CommandLineRunner start(CompteRepository compteRepository,
			RepositoryRestConfiguration repositoryRestConfiguration,
			ClientRepository clientRepository) {
		return args->{
			//l'id est exposeé
			repositoryRestConfiguration.exposeIdsFor(Compte.class);
		
			Client c1 =clientRepository.save(new Client(null,"youssef",null));
			Client c2 =clientRepository.save(new Client(null,"LIli",null));

			
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.COURANT,c1));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.EPARGNE,c2));
			compteRepository.save(new Compte(null,Math.random()*9000,new Date(),TypeCompte.COURANT,c2));
			compteRepository.findAll().forEach(c->{
				System.out.println(c.getSolde());
			});

		};
	}

}
