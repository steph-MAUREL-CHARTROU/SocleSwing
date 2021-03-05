package fr.diginamic.service.gestion;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.daos.ClientDao;
import fr.diginamic.entite.Client;

public class GestionClients extends MenuService {
	
	
	public void traitement() {
		
		console.clear();
		
		Form addClient = new Form();
		
		addClient.addInput(new TextField("Nom :","nomClient"));
		addClient.addInput(new TextField("Prenom :","prenomClient"));
		
		ValidatorClientForm validateFormClient = new ValidatorClientForm();
		
		boolean valide = console.input( "INFORMATIONS", addClient, validateFormClient);
		
		String prenom = addClient.getValue("prenomClient");
		String nom = addClient.getValue("nomClient");
		
		Client clientToAdd = new Client();
		
		clientToAdd.setNom(nom);
		clientToAdd.setPrenom(prenom);
		
		
		ClientDao.insertClient(clientToAdd);
	}

}
