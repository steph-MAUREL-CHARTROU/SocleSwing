package fr.diginamic.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name="voiture")
public class Voiture extends Vehicule{
	

	@Column ( name= " nombre_de_place")
	int nombrePlace;
	
	@ManyToOne
	@JoinColumn ( name=" voiture_type")
	private TypeVehicule typeVehiculeVoiture;
	
	

	public Voiture() {
		
	}

	public Voiture(int idVoiture, int nombrePlace, TypeVehicule typeVehicule) {
		super();
		
		this.nombrePlace = nombrePlace;
		this.typeVehiculeVoiture = typeVehicule;
	}


	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public TypeVehicule getTypeVehicule() {
		return typeVehiculeVoiture;
	}

	public void setTypeVehicule(TypeVehicule typeVehicule) {
		this.typeVehiculeVoiture = typeVehicule;
	}
	
	

}
