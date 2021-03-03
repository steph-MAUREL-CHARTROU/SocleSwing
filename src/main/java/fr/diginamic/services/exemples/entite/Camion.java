package fr.diginamic.services.exemples.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "camion")
public class Camion extends Vehicule {

	int volume;

	public Camion(Long id, String immatriculation, String marque, String modele) {
		super(id, immatriculation, marque, modele);
		// TODO Auto-generated constructor stub
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}
