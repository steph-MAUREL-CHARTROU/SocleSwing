package fr.diginamic.service.gestion;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.daos.ClientDao;
import fr.diginamic.entite.Client;

/**
 * 
 * @author StephanieMC
 *
 */

public class GestionModifClients extends MenuService {
	
	
	public void traitement() {
		
		console.clear();
		
		Form updateForm = new Form();
		//Client c = ClientDao.updateClient(c);
		
//		updateForm.addInput(new TextField("Nom:", "champ1", c.getNom()));
//		updateForm.addInput(new TextField("Prénom:", "champ2", c.getPrenom()));
		
	}

}
