package fr.diginamic.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * 
 * @author StephanieMC
 *
 */

public class Adresse extends AbstractDao {

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public void insertAdresse() {
		
		

	}
	
	public Adresse findAdressById ( int id) {
		
		return em.find( Adresse.class, id);
	}
	
	public  void UpdateAdress( Adresse adresse) {
		
	
		
		
	}
}
