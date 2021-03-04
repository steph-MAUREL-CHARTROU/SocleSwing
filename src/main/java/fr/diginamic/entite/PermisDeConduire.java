package fr.diginamic.entite;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

/**
 * 
 * @author StephanieMC
 *
 */
@Entity
@Table(name = "permis_conduire")
public class PermisDeConduire {
	
	@Id
	int idPermis;

	int NumPermis;
	String type;
	Date dateObtention;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	public PermisDeConduire() {

	}

	public PermisDeConduire(int idPermis, int numPermis, String type, Date dateObtention, Client client) {
		super();
		this.idPermis = idPermis;
		NumPermis = numPermis;
		this.type = type;
		this.dateObtention = dateObtention;
		this.client = client;
	}

	public int getIdPermis() {
		return idPermis;
	}

	public void setIdPermis(int idPermis) {
		this.idPermis = idPermis;
	}

	public int getNumPermis() {
		return NumPermis;
	}

	public void setNumPermis(int numPermis) {
		NumPermis = numPermis;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateObtention() {
		return dateObtention;
	}

	public void setDateObtention(Date dateObtention) {
		this.dateObtention = dateObtention;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
}
