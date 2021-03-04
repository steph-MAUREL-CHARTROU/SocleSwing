package fr.diginamic.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idResa;
	
	@Column( name="date_debut")
	Date dateDebut;
	
	@Column( name="date_fin")
	Date dateFin;
	
	@Column( name ="km_debut_resa")
	int kmDebut;
	
	@Column ( name ="km_fin_resa")
	int KmFin;
	
	@Column ( name = "commentaires")
	String commentaire;
	
	@ManyToOne
	@JoinColumn(name="client_resa")
	private Client client;
	
	@ManyToOne
	@JoinColumn ( name = "vehicule-resa")
	private Vehicule vehicule;
	
	
	@OneToOne
	@JoinColumn ( name= " resa_facture")
	private Facture facture;
	
	

	public Reservation() {

	}

	public Reservation(int idResa, Date dateDebut, Date dateFin, int kmDebut, int kmFin, String commentaire) {
		super();
		this.idResa = idResa;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.kmDebut = kmDebut;
		KmFin = kmFin;
		this.commentaire = commentaire;
	}

	public int getIdResa() {
		return idResa;
	}

	public void setIdResa(int idResa) {
		this.idResa = idResa;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getKmDebut() {
		return kmDebut;
	}

	public void setKmDebut(int kmDebut) {
		this.kmDebut = kmDebut;
	}

	public int getKmFin() {
		return KmFin;
	}

	public void setKmFin(int kmFin) {
		KmFin = kmFin;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
