package fr.diginamic.entite;

import java.util.Date;

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
@Table(name = "maintenance")
public class Maintenance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idMaintenance;
	@Column ( name=" date_entree")
	Date dateEntree;
	@Column ( name =" date_sortie")
	Date dateSortie;
	
	@Column ( name="montant_intervention")
	Double montantIntervention;
	
	@ManyToOne
	@JoinColumn ( name="vehicule_maintenance")
	private Vehicule vehiculeMaintenance;

	public Maintenance() {

	}

	public Maintenance(int idMaintenance, Date dateEntree, Date dateSortie, Double montantIntervention) {
		super();
		this.idMaintenance = idMaintenance;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.montantIntervention = montantIntervention;
	}

	public int getIdMaintenance() {
		return idMaintenance;
	}

	public void setIdMaintenance(int idMaintenance) {
		this.idMaintenance = idMaintenance;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Double getMontantIntervention() {
		return montantIntervention;
	}

	public void setMontantIntervention(Double montantIntervention) {
		this.montantIntervention = montantIntervention;
	}

}
