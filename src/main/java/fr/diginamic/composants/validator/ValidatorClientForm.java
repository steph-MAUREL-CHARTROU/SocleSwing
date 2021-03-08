package fr.diginamic.composants.validator;

import fr.diginamic.composants.ui.Form;

public class ValidatorClientForm extends FormValidator {

	@Override
	public boolean validate(Form form) {
		String nvNom = form.getValue("nomClient");
		String nvPrenom = form.getValue("prenomClient");
		String nvNum = form.getValue("numVoie");
		String nvLibelle = form.getValue("libelleVoie");
		String nvCp = form.getValue("cp");
		String nvTel = form.getValue("numTel");
		String nvEmail = form.getValue("email");
		

		if (nvNom.trim().isEmpty()) {
			console.alert("Le nom est obligatoire !");
			return false;
		} else if (nvPrenom.trim().isEmpty()) {
			console.alert("Le prénom est obligatoire !");
			return false;
		}else if ( nvNum.trim().isEmpty()) {
			
		  console.alert(" le numéro de la rue est obligatoire");
		  return false;
		  
		}  else if( nvLibelle.trim().isEmpty()) {
			console.alert ( " le libellé de la voie est obligatoire");
			return false;
			
		}else if ( nvCp.trim().isEmpty() ) {
			console.alert(" le code postal est obligatoire");
			return false;
		} else if ( nvTel.trim().isEmpty() && nvTel.length() !=10 ) {
			console.alert(" le numéro de telephone est obligatoire et doit comporter 10 chiffres");
			return false;
			//  TODO utilisation d'un regex pour valider le format Email.
		}
		
		return true;
		
		

	}

}
