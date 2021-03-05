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
	private int idVehicule;
	
	@Column ( name = " modele_vehicule")
	private String modeleVehicule;
	
	@Column ( name = "immatriculation")
	private String immatriculation;
	
	@Column ( name ="kilometrage")
	private int kilometrage;
	
	@Column ( name = "statut_vehicule")
	private String statutVehicule;
	
	@OneToMany( mappedBy = "vehicule")
	private List<Reservation> reservation;
	
	@OneToMany ( mappedBy = "vehiculeMaintenance")
	private List<Maintenance> maintenance;

	public Vehicule() {
		
	}

	public Vehicule(int idVehicule, String modeleVehicule, String immatriculation, int kilometrage,
			String statutVehicule) {
		super();
		this.idVehicule = idVehicule;
		this.modeleVehicule = modeleVehicule;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
		this.statutVehicule = statutVehicule;
	}
	
	

}
