package org.sid.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Compte {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double solde;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Enumerated(EnumType.ORDINAL)
	private TypeCompte type;
}
