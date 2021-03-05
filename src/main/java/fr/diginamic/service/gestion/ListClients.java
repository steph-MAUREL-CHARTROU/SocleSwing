package fr.diginamic.service.gestion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.entite.Client;
import fr.diginamic.daos.ClientDao;

/**
 * 
 * @author StephanieMC
 *
 */

public class ListClients extends MenuService {

	public void traitement() {

		console.clear();
		console.print("<h1 class='bg-green'><center>Liste des clients</center></h1>");

//		ClientDao.findAllClients();
//		TypedQuery<Client> query = em.createQuery(" SELECT client FROM Client client", Client.class);
	      
		List<Client> clients = ClientDao.findAllClients();
		String html = "<table cellspacing=0>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Nom</td><td>Prénom</td></tr>";
		for (Client c : clients) {
			html += "<tr>"
				  + "  <td><a class='btn-blue' href='modifier(" + c.getIdClient() + ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
				  + "  <td><a class='btn-red' href='supprimer(" + c.getIdClient() + ")'><img width=25 src='images/trash-red-xs.png'></a></td>"
				  + "  <td width='150px'>" + c.getNom() + "</td>"
				  + "  <td width='150px'>" + c.getPrenom() + "</td>"
				  +"</tr>";
		}
		html += "</table>";

		console.print(html);
	}

	}

