package fr.diginamic.services;

import java.awt.Color;

import fr.diginamic.composants.MenuService;

/**
 * Exemple
 * 
 * @author rbonn
 *
 */
public class LinkService extends MenuService {

	@Override
	public void traitement() {
		console.clear();
		console.print("<h1 class='bg-green'><center>Liste des véhicules</center></h1>");
		
		console.println("Coucou", Color.RED, "font-size:30px;background-color: green");
		
		console.print("<table cellspacing=0>"
				+ "<tr class='bg-green'><td class=''>&nbsp;</td><td class=''>&nbsp;</td><td class=''>Immatriculation</td></tr>"
				+ "<tr><td><a class='btn-blue' href='linkService.modifier(22)'><img src='images/pencil-blue.png'></a></td><td><a class='btn-red' href='linkService.supprimer(22)'><img src='images/trash-red.png'></a></td><td>Véhicule CV-HR-123</td></tr>"
				+ "<tr><td><a class='btn-blue' href='linkService.modifier(23)'><img src='images/pencil-blue.png'></a></td><td><a class='btn-red' href='linkService.supprimer(23)'><img src='images/trash-red.png'></a></td><td>Véhicule CV-HR-123</td></tr>"
				+ "</table>");
	}

	public void modifier(Long id) {
		console.println("Modification de l'item " + id, Color.GREEN);
	}

	public void supprimer(Long id) {
		console.println("Suppression de l'item " + id, Color.RED);
	}

}
