package fr.diginamic.services.exemples.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */

@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	
	@Column( name= " nom_client")
	private String nom;
	
	@Column ( name=" prenom_client")
	private String prenom;

	
	@OneToMany
	@JoinColumn( name = "reservation_client")
	private Reservation reservation;
	
	@Embedded
	private Adresse adresse;
	
	@OneToMany( mappedBy = "permis_de_conduire")
	private List<PermisDeConduire> permisconduire;
	
	
	public Client() {
		
	}

	public Client(Long idClient, String nom, String prenom) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}