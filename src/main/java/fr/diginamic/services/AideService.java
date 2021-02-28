package fr.diginamic.services;

import java.awt.Color;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;

/** Exemple
 * @author rbonn
 *
 */
public class AideService extends MenuService {

	@Override
	public void traitement() {
		console.clear();
		console.println("Bonjour", Color.RED);
		
		
		Form form = new Form();
		form.addInput(new TextField("nom", "Nom"));
		form.addInput(new TextField("prenom", "Prénom"));
		form.addInput(new DateField("dateNaissance", "Date de naissance", 80));

		boolean valide = console.input("Demande de nom", form);
		
		if (valide) {
			console.html("Vous vous <b>appelez</b> ").html("<span style='color:red'>"+form.getValue("prenom")+" "+form.getValue("nom")+"</span>");
	
		
			console.html("<table style='border:1px solid black'>");
			console.html("<tr><td>id</td><td>Nom</td><td>Prénom</td></tr>");
			console.html("</table>");
		}
	}

}
