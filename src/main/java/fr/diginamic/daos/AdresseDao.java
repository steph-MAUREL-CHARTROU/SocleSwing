package fr.diginamic.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * 
 * @author StephanieMC
 *
 */

public class AdresseDao extends AbstractDao {

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public void insertAdresse() {
		
		

	}
	
	public AdresseDao findAdressById ( int id) {
		
		return em.find( AdresseDao.class, id);
	}
	
	public  void UpdateAdress( AdresseDao adresse) {
		
	
		
		
	}
}
