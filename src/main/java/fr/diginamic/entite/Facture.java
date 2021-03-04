package fr.diginamic.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idFacture;
	@Column ( name="mode_paiement")
	String typePaiement;
	
	@Column ( name =" montant_facture")
	Double montantFacture;
	
	

	@Column ( name = "statut_facture")
	boolean statut;
	
	@OneToOne
	@JoinColumn ( name = "resa_facture")
	private Reservation reservation;

	public Facture() {

	}

	public Facture(int idFacture, String typePaiement,Double montantFacture, boolean statut) {
		super();
		this.idFacture = idFacture;
		this.typePaiement = typePaiement;
		this.statut = statut;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public String getTypePaiement() {
		return typePaiement;
	}

	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}

	public boolean isStatut() {
		return statut;
	}

	public Double getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(Double montantFacture) {
		this.montantFacture = montantFacture;
	}
}
