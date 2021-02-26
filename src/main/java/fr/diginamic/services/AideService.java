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

		String saisie = Console.input("Comment vous appelez-vous ?");
		
		console.print("Vous vous appelez ").println(saisie, Color.RED);

		
		console.println("fin");
	}

}
