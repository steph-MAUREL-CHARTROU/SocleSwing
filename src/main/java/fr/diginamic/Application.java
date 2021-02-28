package fr.diginamic;

import fr.diginamic.composants.AbstractApplication;
import fr.diginamic.services.AideService;
import fr.diginamic.services.LinkService;

/**
 * Fenêtre principale qui porte les principaux composants graphiques de
 * l'application:<br>
 * - les boutons du menu,<br>
 * - le panneau d'affichage des résultats<br>
 * 
 * @author RichardBONNAMY
 *
 */
public class Application extends AbstractApplication {

	/** serialVersionUID */
	private static final long serialVersionUID = 6755835482616236832L;
	
	/** Constructeur
	 * @param title titre
	 */
	public Application(String title) {
		super(title);
	}

	/**
	 * Code principal
	 * 
	 */
	public void main() {
		addMenu(1, "File");
		addMenu(2, "Recherche");
		addMenu(3, "Rapports");
		
		addMenuOption(1, "Aide", new AideService());
		addMenuOption(2, "Par nom", new LinkService());
		addMenuOption(3, "Edition", new AideService());
	}
}