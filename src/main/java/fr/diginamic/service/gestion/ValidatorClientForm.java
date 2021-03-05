package fr.diginamic.service.gestion;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

public class ValidatorClientForm extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String nvNom = form.getValue("cham");
		String nvPrenom = form.getValue("champ2");

		if (nvNom.trim().isEmpty()) {
			console.alert("Le nom est obligatoire !");
			return false;
		} else if (nvPrenom.trim().isEmpty()) {
			console.alert("Le prénom est obligatoire !");
			return false;
		}
		return false;

	}

}
