package fr.diginamic.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Client;
import fr.diginamic.entite.Voiture;

/**
 * 
 * @author StephanieMC
 *
 */

public class VoitureDao extends AbstractDao {

	private EntityManager em = AbstractDao.emf.createEntityManager();

	public VoitureDao() {

	}

	public void insertVoiture(Voiture voiture) {

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		em.persist(voiture);
		transaction.commit();

		System.out.println("vous avez bien ajouté " + voiture);

	}

	public Voiture findById(int id) {

		return em.find(Voiture.class, id);
	}

	public List<Voiture> findAllCars() {

		TypedQuery<Voiture> query = em.createQuery(" SELECT voit FROM Voiture voit", Voiture.class);
		return query.getResultList();
	}

	public void updateCar(Voiture voiture) {

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Voiture carToUpdate = findById(voiture.getTypeVehicule().getIdTypeVehicule());
		carToUpdate.setNombrePlace(0);
		transaction.commit();

		System.out.println(" modification ok ");

	}
	
public void deleteCar(Voiture voiture ) {
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		Voiture carToDelete = findById(voiture.getTypeVehicule().getIdTypeVehicule());
		em.remove(carToDelete );
		
		transaction.commit();

	}

}
