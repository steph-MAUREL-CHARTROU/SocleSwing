
package fr.diginamic.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "type_vehicule")
public class TypeVehicule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idTypeVehicule;
	
	@Column (name = "type_vehicule")
	String nomTypeVehicule;
	
	@Column (name = "tarif_jour ")
	Double tarifJour;
	
	@Column (name= "montant_caution")
	int montantCaution;
	
	@OneToMany (mappedBy = "typeVehiculeVoiture")
	private List <Voiture> voiture;
	
	@OneToMany(mappedBy = "typeVehiculeCamion")
	private List <Camion> camion;
	

	public TypeVehicule() {

	}

	public TypeVehicule( String nomTypeVehicule, Double tarifJour, int montantCaution) {
		super();
		this.nomTypeVehicule = nomTypeVehicule;
		this.tarifJour = tarifJour;
		this.montantCaution = montantCaution;
	}

	public int getIdTypeVehicule() {
		return idTypeVehicule;
	}

	public void setIdTypeVehicule(int idTypeVehicule) {
		this.idTypeVehicule = idTypeVehicule;
	}

	public String getNomTypeVehicule() {
		return nomTypeVehicule;
	}

	public void setNomTypeVehicule(String nomTypeVehicule) {
		this.nomTypeVehicule = nomTypeVehicule;
	}

	public Double getTarifJour() {
		return tarifJour;
	}

	public void setTarifJour(Double tarifJour) {
		this.tarifJour = tarifJour;
	}

	public int getMontantCaution() {
		return montantCaution;
	}

	public void setMontantCaution(int montantCaution) {
		this.montantCaution = montantCaution;
	}

}
