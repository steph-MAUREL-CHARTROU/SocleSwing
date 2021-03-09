package fr.diginamic.composants.validator;

import fr.diginamic.composants.ui.Form;

/**
 * 
 * @author StephanieMC
 *
 */

public class ValidatorCarForm extends FormValidator {

	public boolean validate(Form form) {

		String modele = form.getValue(" modele");
		String nbrPlaces = form.getValue("nbrPlaces");
		String immat = form.getValue("immat");
		String km = form.getValue("km");
		String statut = form.getValue("statut");

		if (modele.trim().isEmpty()) {

			console.alert(" Saisie Obligatoire :  Veuillez entrer un mod�le de v�hicule");
			return false;

		} else if (nbrPlaces.trim().isEmpty()) {
			console.alert(" saisie Obligatoire : Veuillez saisir le nombre de place du v�hicule");
			return false;
			
		} else if (immat.trim().isEmpty()) {

			// TODO V�rificatio du format immatriculation
			console.alert(" Saison Obligatoire : Veuillez entrer une immatriculation valide");
			return false;

		} else if (km.trim().isEmpty()) {

			console.alert("Saisie Obligatoire : Veuillez saisir le kilom�trage du v�hicule");
			return false;

		} else if (statut.trim().isEmpty()) {

			console.alert("Saisie obligatoire : Veuillez saisir le statut du v�hicule");
			return false;
			// TODO verification du statut � faire autrement , automatisation boolean true
			// ou false
		}

		return true;

	}

}
