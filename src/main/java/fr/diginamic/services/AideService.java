package fr.diginamic.services;

import java.awt.Color;

import fr.diginamic.composants.Console;
import fr.diginamic.composants.MenuService;

/** Exemple
 * @author rbonn
 *
 */
public class AideService extends MenuService {

	@Override
	public void traitement() {
		console.clear();
		console.println("Bonjour", Color.RED);


		String saisie = Console.input("Comment vous appelez-vous ?");
		
		console.html("Vous vous <b>appelez</b> ").html("<span style='color:red'>"+saisie+"</span>");

	
		console.html("<table style='border:1px solid black'>");
		console.html("<tr><td>id</td><td>Nom</td><td>Prénom</td></tr>");
		console.html("</table>");
	}

}
