package fr.diginamic.daos;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import fr.diginamic.entite.TypeVehicule;

/**
 * 
 * @author StephanieMC
 *
 */


public class TypeVehiculeDao extends AbstractDao {
	
	private EntityManager em = AbstractDao.emf.createEntityManager();
	
	public TypeVehiculeDao() {
		// TODO Auto-generated constructor stub
	}
	
   public void insertTypeVehicule(TypeVehicule typeVehicule) {
	   
	   EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.persist(typeVehicule);
		transaction.commit();

		System.out.println("vous avez bien ajouté " + typeVehicule);

	   
   }
  
}
