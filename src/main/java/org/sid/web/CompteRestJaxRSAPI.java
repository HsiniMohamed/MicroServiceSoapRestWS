package org.sid.web;

import java.util.List;

import org.sid.entities.Compte;
import org.sid.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
	@Autowired
	private CompteRepository compteRepository;
	@Path("/comptes")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Compte> compteList(){
			return compteRepository.findAll();
	}
	
	@Path("/comptes/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Compte getOne(@PathParam(value = "id")Long id){
			return compteRepository.findById(id).get();
	}
	
	@Path("/comptes")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Compte save(Compte compte){
			return compteRepository.save(compte);
	}
	
	@Path("/comptes/{id}")
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	public Compte update(Compte compte, @PathParam(value = "id")Long id){
			compte.setId(id);
			return compteRepository.save(compte);
	}
	@Path("/comptes/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	public void delete( @PathParam(value = "id")Long id){
			compteRepository.deleteById(id);
	}

}
