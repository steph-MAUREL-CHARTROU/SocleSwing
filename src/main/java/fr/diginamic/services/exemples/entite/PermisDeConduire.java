package fr.diginamic.services.exemples.entite;

import java.util.Date;

import javax.persistence.Entity;
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

	int NumPermis;
	String type;
	Date dateObtention;
	
	@ManyToOne
	@JoinColumn(name="permis_de_conduire")
	private Client client;

	public PermisDeConduire() {

	}

	public PermisDeConduire(int numPermis, String type, Date dateObtention) {
		super();
		NumPermis = numPermis;
		this.type = type;
		this.dateObtention = dateObtention;
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

}
