
package fr.diginamic.entite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author StephanieMC
 *
 */
@Embeddable
public class Adresse {
	
	@Column ( nullable = true)
	int numRue;
	@Column ( nullable = true)
	String libelleRue;
	@Column ( nullable = true)
	int codePostal;
	@Column ( nullable = true)
	String numTel;
	@Column ( nullable = true)
	String email;
	
	
	
	public Adresse() {
		
	}

	public Adresse(int numRue, String libelleRue, int codePostal, String numTel, String email) {
		super();
		this.numRue = numRue;
		this.libelleRue = libelleRue;
		this.codePostal = codePostal;
		this.numTel = numTel;
		this.email = email;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public String getLibelleRue() {
		return libelleRue;
	}

	public void setLibelleRue(String libelleRue) {
		this.libelleRue = libelleRue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
