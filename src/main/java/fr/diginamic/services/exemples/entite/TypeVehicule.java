package fr.diginamic.services.exemples.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "type_vehicule")
public class TypeVehicule {

	int idTypeVehicule;
	String nomTypeVehicule;
	Double tarifJour;
	int montantCaution;

	public TypeVehicule() {

	}

	public TypeVehicule(int idTypeVehicule, String nomTypeVehicule, Double tarifJour, int montantCaution) {
		super();
		this.idTypeVehicule = idTypeVehicule;
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
