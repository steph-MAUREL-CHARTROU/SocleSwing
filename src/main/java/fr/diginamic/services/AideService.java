package fr.diginamic.services;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
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
		form.addInput(new DateField("dateNaissance", "Date de naissance"));
		
		List<Selectable> vehicules = new ArrayList<>();
		vehicules.add(new Vehicule(1L, "AA-552-CD", "Peugeot", "208"));
		vehicules.add(new Vehicule(2L, "AW-227-XE", "Peugeot", "3008"));
		vehicules.add(new Vehicule(3L, "XX-131-XT", "Peugeot", "3008"));
		
		form.addInput(new ComboBox("vehicule", "Véhicule", vehicules));

		boolean valide = console.input("Demande de nom", form);
		
		console.print("<table><tr><td><a href=\"a1\">Cell1</a></td><td><a href=\"a2\">Cell2</a></td></tr></table>");
		
		if (valide) {
			console.print("Vous vous <b>appelez</b> ").println("<span style='color:red'>"+form.getValue("prenom")+" "+form.getValue("nom")+"</span>");
			console.println("Voiture sélectionnée :"+form.getValue("vehicule"));
			console.println("Date de naissance :"+form.getValue("dateNaissance"));
		}
	}

}
