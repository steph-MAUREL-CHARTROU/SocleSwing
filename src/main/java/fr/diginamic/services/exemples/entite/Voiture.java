package fr.diginamic.services.exemples.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name="voiture")
public class Voiture extends Vehicule {
	
	
	int nombrePlace;
	

	public Voiture(Long id, String immatriculation, String marque, String modele) {
		super(id, immatriculation, marque, modele);
		
	}


	public int getNombrePlace() {
		return nombrePlace;
	}


	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	
	

}
