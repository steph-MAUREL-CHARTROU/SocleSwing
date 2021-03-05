package fr.diginamic.service.gestion;

import javax.persistence.EntityTransaction;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.composants.validator.ValidatorClientForm;
import fr.diginamic.daos.ClientDao;
import fr.diginamic.entite.Client;

/**
 * 
 * @author StephanieMC
 *
 */

public class GestionModifClients extends MenuService {
	
	private ClientDao clientDao = new ClientDao();
	
	public void traitement() {
		
		console.clear();
		
		Form updateForm = new Form();
		
		
		Client c = new Client();
		
		updateForm.addInput(new TextField("Nom:", "updateNom", c.getNom()));
		updateForm.addInput(new TextField("Prénom:", "updatePrenom", c.getPrenom()));
		
		ValidatorClientForm validateFormClient = new ValidatorClientForm();

		
		
		boolean valide = console.input("Modification du client "+c.getPrenom()+" "+c.getNom(), updateForm, validateFormClient);
		if (valide) {
			
		
			String nvNom = updateForm.getValue("updateNom");
			String nvPrenom = updateForm.getValue("updatePrenom");
			c.setNom(nvNom);
			c.setPrenom(nvPrenom);
		
			traitement();
		
	}

	}
}
