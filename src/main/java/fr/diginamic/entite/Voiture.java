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

	public Voiture(
			String modeleVehicule, 
			String immatriculation,
			int kilometrage,
			String statutVehicule,
			int nombrePlace)
	{
		this.modeleVehicule = modeleVehicule;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
		this.statutVehicule = statutVehicule;
		this.nombrePlace = nombrePlace;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	
	public String getModeleVehicule() {
		return modeleVehicule;
	}

	public void setModeleVehicule(String modeleVehicule) {
		this.modeleVehicule = modeleVehicule;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getStatutVehicule() {
		return statutVehicule;
	}

	public void setStatutVehicule(String statutVehicule) {
		this.statutVehicule = statutVehicule;
	}

	public TypeVehicule getTypeVehicule() {
		return typeVehiculeVoiture;
	}

	public void setTypeVehicule(TypeVehicule typeVehicule) {
		this.typeVehiculeVoiture = typeVehicule;
	}
	
	

}
