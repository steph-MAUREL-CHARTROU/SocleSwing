package fr.diginamic.service.gestion;

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

public class GestionAjoutClients extends MenuService {

	
	private ClientDao clientDao = new ClientDao();

	public void traitement() {

		console.clear();

		Form addClient = new Form();

		addClient.addInput(new TextField("Nom :", "nomClient"));
		addClient.addInput(new TextField("Prenom :", "prenomClient"));

		ValidatorClientForm validateFormClient = new ValidatorClientForm();

		boolean valide = console.input("demande d'informations", addClient, validateFormClient);

		String prenom = addClient.getValue("prenomClient");
		String nom = addClient.getValue("nomClient");

		Client clientToAdd = new Client();

		clientToAdd.setNom(nom);
		clientToAdd.setPrenom(prenom);

		clientDao.insertClient(clientToAdd);

	}

}
