package fr.diginamic.entite;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "camion")
public class Camion extends Vehicule {
	

	
	@Column ( name = "volume_camion")
	int volume;

	@ManyToOne
	@JoinColumn (name = "camion_type")
	private TypeVehicule typeVehiculeCamion;

	public Camion(String immatriculation, String marque, String modele, int idCamion, int volume,
			TypeVehicule typeVehicule) {
		super(volume, immatriculation, marque, volume, modele);
		this.volume = volume;
		this.typeVehiculeCamion = typeVehicule;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public TypeVehicule getTypeVehiculeCamion() {
		return typeVehiculeCamion;
	}

	public void setTypeVehiculeCamion(TypeVehicule typeVehiculeCamion) {
		this.typeVehiculeCamion = typeVehiculeCamion;
	}
	
	

}
