package fr.diginamic.services.exemples;

import java.awt.Color;

import fr.diginamic.composants.MenuService;

public class Exemple2Service extends MenuService {

	@Override
	public void traitement() {
		console.clear();
		
		console.print("<h1 class='bg-dark-blue'><center>Exemple fond bleu foncé</center></h1>");
		
		console.println("Texte");
		console.println("Texte en rouge", Color.RED);
		console.println("Texte en cyan", Color.DARK_GRAY);
		
		console.println("Texte utilisant des attributs CSS", "color:#AABBCC; font-size:40px");
	}

}
