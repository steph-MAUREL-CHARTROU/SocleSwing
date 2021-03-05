package fr.diginamic.composants;

import java.util.concurrent.Callable;

import fr.diginamic.composants.error.ErrorManager;

/** Traitement asynchrone permettant d'ex�cuter un service
 * @author RichardBONNAMY
 *
 */
public class TraitementMenu implements Callable<Void> {
	
	/** menuService */
	private MenuService menuService;
	
	/** Constructeur
	 * @param menuService service � ex�cuter en asynchrone
	 */
	public TraitementMenu(MenuService menuService) {
		this.menuService=menuService;
	}

	@Override
	public Void call() {
		try {
			menuService.traitement();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			ErrorManager.manage(e.getMessage(), e);
		}
		return null;
	}

}