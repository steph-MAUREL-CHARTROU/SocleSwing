package fr.diginamic.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.diginamic.entite.Vehicule;

/**
 * 
 * @author StephanieMC
 *
 */

public class VehiculeDao extends AbstractDao{
	
	private EntityManager em = AbstractDao.emf.createEntityManager();
	
	public VehiculeDao() {
			
	}
	
	public void insertVehicule(Vehicule vehicule) {
		
		 EntityTransaction transaction = em.getTransaction();

			transaction.begin();
			em.persist(vehicule);
			transaction.commit();

			System.out.println("vous avez bien ajouté " + vehicule);

	}

}
