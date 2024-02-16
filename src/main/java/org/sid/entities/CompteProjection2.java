package org.sid.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde",types = Compte.class)
public interface CompteProjection2 {

	public double getSolde();
	
}
