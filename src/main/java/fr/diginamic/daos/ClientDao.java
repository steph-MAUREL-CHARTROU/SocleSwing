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

	private static EntityManager em = AbstractDao.emf.createEntityManager();
	private static EntityTransaction transaction = em.getTransaction();

	public ClientDao() {

	}

	public static void insertClient(Client client) {

		Query query = em.createQuery(" SELECT client FROM Client client WHERE client.nom= ?1");
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

	public List<Client> findAllClients() {

		TypedQuery<Client> query = em.createQuery(" SELECT client FROM Client client", Client.class);
		return query.getResultList();

	}

	public void updateClient(Client client) {

		Client clientToUpdate = findById(client.getIdClient());
		clientToUpdate.setPrenom(client.getPrenom());
		clientToUpdate.setNom(client.getNom());
	}

	public void deleteClient(Client client) {
		
		Client clientToDelete = findById(client.getIdClient());
		em.remove( clientToDelete);

	}
}
