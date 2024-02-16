package org.sid.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @AllArgsConstructor @NoArgsConstructor 
public class Client {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String nom;
	@OneToMany(mappedBy = "client")
	private Collection<Compte> comptes;
}
