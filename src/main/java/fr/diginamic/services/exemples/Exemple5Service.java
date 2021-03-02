package fr.diginamic.services.exemples;

import java.awt.Color;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.db.SqlUtils;
import fr.diginamic.services.entite.Client;

public class Exemple5Service extends MenuService {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2-mem");

	private void initDatabase() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		List<Client> clients = query.getResultList();
		if (clients.size()==0) {
			SqlUtils.executeFile("exemple.sql", em);
		}
	}

	@Override
	public void traitement() {

		// La méthode initDatabase permet ici d'initialiser la base avec des données de
		// tests
		initDatabase();

		// Exemple
		EntityManager em = emf.createEntityManager();
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		List<Client> clients = query.getResultList();

		console.clear();
		console.print("<h1 class='bg-green'><center>Liste des clients</center></h1>");

		String html = "<table cellspacing=0>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Nom</td><td>Prénom</td></tr>";
		for (Client c : clients) {
			html += "<tr>"
				  + "  <td><a class='btn-blue' href='modifier(" + c.getId()+ ")'><img src='images/pencil-blue.png'></a></td>"
				  + "  <td><a class='btn-red' href='supprimer("+ c.getId() + ")'><img src='images/trash-red.png'></a></td>"
				  + "  <td>" + c.getNom() + "</td>"
				  + "  <td>" + c.getPrenom() + "</td>"
				  +"</tr>";
		}
		html += "</table>";

		console.print(html);
	}

	public void modifier(Long id) {
		console.println("Modification de l'item " + id, Color.GREEN);
	}

	public void supprimer(Long id) {
		console.println("Suppression de l'item " + id, Color.RED);
	}

}
