package org.sid.repositories;

import java.util.List;

import org.sid.entities.Compte;
import org.sid.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

	@RestResource(path="/byType")
	public List<Compte> findByType(@Param("t") TypeCompte type);
}
