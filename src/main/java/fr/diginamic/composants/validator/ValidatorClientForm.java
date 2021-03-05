package fr.diginamic.composants.validator;

import fr.diginamic.composants.ui.Form;

public class ValidatorClientForm extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String nvNom = form.getValue("nomClient");
		String nvPrenom = form.getValue("prenomClient");

		if (nvNom.trim().isEmpty()) {
			console.alert("Le nom est obligatoire !");
			return false;
		} else if (nvPrenom.trim().isEmpty()) {
			console.alert("Le prénom est obligatoire !");
			return false;
		}
		return true;

	}

}
