package fr.diginamic.services.exemples;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.ComboBox;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Selectable;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.services.entite.Vehicule;

public class Exemple6Service extends MenuService {

	@Override
	public void traitement() {

		console.clear();
		console.print("<h1 class='bg-turquoise'><center>Titre avec fond bleu clair</center></h1>");

		Form form = new Form();
		
		// Champ de type texte
		form.addInput(new TextField("nom", "Nom"));
		form.addInput(new TextField("prenom", "Prénom"));
		
		// Champd e type date
		form.addInput(new DateField("dateNaissance", "Date de naissance"));
		
		
		List<Selectable> vehicules = new ArrayList<>();
		vehicules.add(new Vehicule(1L, "AA-552-CD", "Peugeot", "208"));
		vehicules.add(new Vehicule(2L, "AW-227-XE", "Peugeot", "3008"));
		vehicules.add(new Vehicule(3L, "XX-131-XT", "Peugeot", "3008"));
		
		// Champ de type liste de sélection
		form.addInput(new ComboBox("vehicule", "Véhicule", vehicules));

		// Appel du formulaire.
		boolean valide = console.input("Demande de nom", form);

		// Récupéation des informations saisies
		if (valide) {
			console.print("Vous vous <b>appelez</b> ").println("<span style='color:red'>"+form.getValue("prenom")+" "+form.getValue("nom")+"</span>");
			console.println("Voiture sélectionnée :"+form.getValue("vehicule"));
			console.println("Date de naissance :"+form.getValue("dateNaissance"));
		}
		
	}

	public void modifier(Long id) {
		console.println("Modification de l'item " + id, Color.GREEN);
	}

	public void supprimer(Long id) {
		console.println("Suppression de l'item " + id, Color.RED);
	}

}
