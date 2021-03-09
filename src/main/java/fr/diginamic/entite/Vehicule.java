package fr.diginamic.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity

@Table ( name="vehicule")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idVehicule;
	
	@Column ( name = " modele_vehicule")
	protected String modeleVehicule;
	
	@Column ( name = "immatriculation")
	protected String immatriculation;
	
	@Column ( name ="kilometrage")
	protected int kilometrage;
	
	@Column ( name = "statut_vehicule")
	protected String statutVehicule;
	
	@OneToMany( mappedBy = "vehicule")
	private List<Reservation> reservation;
	
	@OneToMany ( mappedBy = "vehiculeMaintenance")
	private List<Maintenance> maintenance;

	public Vehicule() {
		
	}

	public Vehicule(String modeleVehicule, String immatriculation, int kilometrage,
			String statutVehicule) {
		this.modeleVehicule = modeleVehicule;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
		this.statutVehicule = statutVehicule;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
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

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}

	public List<Maintenance> getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(List<Maintenance> maintenance) {
		this.maintenance = maintenance;
	}
	
	

}
