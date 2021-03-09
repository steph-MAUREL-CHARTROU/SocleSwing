package fr.diginamic.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.diginamic.entite.Client;

/**
 * 
 * @author StephanieMC
 *
 */

public class ClientDao extends AbstractDao {

	private EntityManager em = AbstractDao.emf.createEntityManager();

	public ClientDao() {

	}

	public void insertClient(Client client) {

		EntityTransaction transaction = em.getTransaction();
		TypedQuery<Client> query = em.createQuery(" SELECT client FROM Client client WHERE client.nom= ?1",
				Client.class);
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

	public Client findById(Long long1) {

		return em.find(Client.class, long1);

	}

	public  List<Client> findAllClients() {

		TypedQuery<Client> query = em.createQuery(" SELECT voiture FROM Voiture client", Client.class);
		return query.getResultList();

	}

	public void updateClient(Client client) {
		
		EntityTransaction transaction = em.getTransaction();


		transaction.begin();

		Client clientToUpdate = findById(client.getIdClient());
		clientToUpdate.setPrenom(client.getPrenom());
		clientToUpdate.setNom(client.getNom());
		
		transaction.commit();
		
		System.out.println(" modification ok ");

	}

	public void deleteClient(Client client ) {
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		Client clientToDelete = findById(client.getIdClient());
		em.remove( clientToDelete);
		
		transaction.commit();

	}

}

