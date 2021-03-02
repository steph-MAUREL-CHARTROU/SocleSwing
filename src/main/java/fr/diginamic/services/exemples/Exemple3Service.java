package fr.diginamic.services.exemples;

import fr.diginamic.composants.MenuService;

public class Exemple3Service extends MenuService {

	@Override
	public void traitement() {
		console.clear();
		
		console.print("<h1 class='bg-dark-blue'><center>Exemple fond bleu foncé</center></h1>");
		
		// Utilisation de la classe bg-green pour l'entêtete de la table
		String html = "<table cellspacing=0>"
				    + "   <tr class='bg-green'><td>Nom</td><td>Prénom</td></tr>"
		            + "   <tr><td>MBAPPE</td><td>Kylian</td></tr>"
			        + "   <tr><td>NEYMAR</td><td>Junior</td></tr>"
			        + "   <tr><td>MOISE</td><td>Kean</td></tr>"
		            + "</table>";
		console.print(html);
	}
}
