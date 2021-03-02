package fr.diginamic.services.exemples;

import java.awt.Color;

import fr.diginamic.composants.MenuService;

/** Exemple
 * @author rbonn
 *
 */
public class AideService extends MenuService {

	@Override
	public void traitement() {
		
		console.clear();
		console.println("Aide", Color.RED);
	}

}
