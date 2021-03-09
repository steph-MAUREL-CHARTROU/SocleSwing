package fr.diginamic.service.gestion;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.composants.validator.ValidatorCarForm;
import fr.diginamic.daos.TypeVehiculeDao;
import fr.diginamic.daos.VehiculeDao;
import fr.diginamic.daos.VoitureDao;
import fr.diginamic.entite.Maintenance;
import fr.diginamic.entite.TypeVehicule;
import fr.diginamic.entite.Vehicule;
import fr.diginamic.entite.Voiture;

/**
 * 
 * @author StephanieMC
 *
 */

public class GestionAjoutVoiture extends MenuService {
	


	private VoitureDao voitureDao = new VoitureDao();


	public void traitement() {

		console.clear();

		Form addCarForm = new Form();
		
	
		addCarForm.addInput(new TextField("Modèle du véhicule :" , "modele"));
		addCarForm.addInput(new TextField("Nombre de places : ", "nbrPlaces"));
		addCarForm.addInput(new TextField("Immatriculation :" , "immat"));
		addCarForm.addInput(new TextField("Kilométrage :" , "km"));
		addCarForm.addInput(new TextField("Statut du véhicule :" , "statut"));
		
		ValidatorCarForm validateCarForm = new ValidatorCarForm();
		boolean valide = console.input("Ajout d'un nouveau véhicule", addCarForm, validateCarForm);
		
		
		if ( valide ) {
			
			
			Voiture carToAdd = new Voiture(
					addCarForm.getValue("modele"),
					addCarForm.getValue("immat"),
					Integer.parseInt(addCarForm.getValue("km")),
					addCarForm.getValue("statut"),
					Integer.parseInt(addCarForm.getValue("nbrPlaces")));
			
			int nbrPlaces = Integer.parseInt(addCarForm.getValue("nbrPlaces"));
			String modele = addCarForm.getValue("immat");
			String immat = addCarForm.getValue("immat");
			int km = Integer.parseInt(addCarForm.getValue("km"));
			String statut = addCarForm.getValue("statut");
			
			
			carToAdd.setImmatriculation(immat);
			carToAdd.setKilometrage(km);
			carToAdd.setModeleVehicule(modele);
			carToAdd.setStatutVehicule(statut);
			carToAdd.setNombrePlace(nbrPlaces);
			
			voitureDao.insertVoiture(carToAdd);
			
		}		

	}
}
