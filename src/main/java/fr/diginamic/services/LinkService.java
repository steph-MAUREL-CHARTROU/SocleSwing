package fr.diginamic.services;

import fr.diginamic.composants.MenuService;

/** Exemple
 * @author rbonn
 *
 */
public class LinkService extends MenuService {

	@Override
	public void traitement() {
		
		console.html("<h1>Coucou</h1>");
		console.html("<table>"
				+ "<tr><td><a class='btn-blue' href='linkService.modifier(22)'>Modifier</a></td><td><a class='btn-red' href='linkService.supprimer(22)'>Supprimer</a></td><td>Véhicule CV-HR-123</td></tr>"
				+ "<tr><td><a class='btn-blue' href='linkService.modifier(23)'>Modifier</a></td><td><a class='btn-red' href='linkService.supprimer(22)'>Supprimer</a></td><td>Véhicule CV-HR-123</td></tr>"
				+ "</table>");
		
	}
	
	public void modifier(Long id) {
		console.html("Modification de l'item "+id);
	}
	
	public void supprimer(Long id) {
		console.html("Suppression de l'item "+id);
	}

}
