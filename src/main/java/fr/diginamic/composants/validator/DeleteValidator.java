package fr.diginamic.composants.validator;

import fr.diginamic.composants.ui.Form;

public class DeleteValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String nvNom = form.getValue("nomClient");
		String nvPrenom = form.getValue("prenomClient");
		
		if ( nvNom.trim().isEmpty()) {
			console.alert("Vérifier que c'est bien le client que vous voulez supprimer ");
		}
		
		return true;
	}
	
}
