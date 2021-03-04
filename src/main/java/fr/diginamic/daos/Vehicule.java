package fr.diginamic.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.diginamic.entite.Client;

/**
 * 
 * @author StephanieMC
 *
 */
public class Vehicule {
	
	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public void insertVehicule(Client client) {

		Query query = em.createQuery(" SELECT vehicule FROM Vehicule vehicule WHERE vehicule.nom= ?1");
		query.setParameter(1, client.getNom());

		List<Client> clientList = query.getResultList();

		if (clientList.isEmpty()) {

			transaction.begin();
			em.persist(client);

			transaction.commit();
		} else {

			client.setIdClient(clientList.get(0).getIdClient());
		}

	}
	
}
