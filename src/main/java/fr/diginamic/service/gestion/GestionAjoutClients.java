package fr.diginamic.service.gestion;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.composants.validator.ValidatorClientForm;
import fr.diginamic.daos.ClientDao;
import fr.diginamic.entite.Adresse;
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
		addClient.addInput(new TextField("N° de la voie :", "numVoie" ));
		addClient.addInput(new TextField(" Libellé  :", "libelleVoie" ));
		addClient.addInput(new TextField("Code Postal :", "cp" ));
		addClient.addInput(new TextField("N° Tel :", "numTel" ));
		addClient.addInput(new TextField("Email :", "email" ));

		ValidatorClientForm validateFormClient = new ValidatorClientForm();

		boolean valide = console.input("Ajout d'un nouveau client", addClient, validateFormClient);
		
		if (valide) {
			
			Adresse adresse = new Adresse(Integer.parseInt(addClient.getValue("numVoie")),
					addClient.getValue("libelleVoie"),
					Integer.parseInt(addClient.getValue("cp")),
					addClient.getValue("numTel"),
					addClient.getValue("email"));
				
			
			Client clientToAdd = new Client(addClient.getValue("nomClient"),
						 addClient.getValue("prenomClient"));
			
			String prenom = addClient.getValue("prenomClient");
			String nom = addClient.getValue("nomClient");
			
			clientToAdd.setNom(nom);
			clientToAdd.setPrenom(prenom);
			clientToAdd.setAdresse(adresse);

			clientDao.insertClient(clientToAdd);
			
		}
		

		
	}

}
