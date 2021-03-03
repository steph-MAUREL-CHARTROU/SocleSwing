package fr.diginamic.services.exemples.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "facture")
public class Facture {

	int idFacture;
	String typePaiement;
	boolean statut;

	public Facture() {

	}

	public Facture(int idFacture, String typePaiement, boolean statut) {
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

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

}
