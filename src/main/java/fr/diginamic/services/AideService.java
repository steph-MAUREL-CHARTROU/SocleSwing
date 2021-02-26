package fr.diginamic.services;

import java.awt.Color;

import fr.diginamic.composants.Console;
import fr.diginamic.composants.MenuService;

public class AideService extends MenuService {

	@Override
	public void traitement() {
		
		console.println("Bonjour");

		String saisie = Console.input("Comment vous appelez-vous ?");
		console.print("Vous vous appelez ").println(saisie, Color.RED);
		String saisie2 = Console.input("Comment vous appelez-vous ?");
		console.print("Vous vous appelez ").println(saisie2, Color.RED);
		String saisie3 = Console.input("Comment vous appelez-vous ?");
		console.print("Vous vous appelez ").println(saisie3, Color.RED);
		String saisie4 = Console.input("Comment vous appelez-vous ?");
		console.print("Vous vous appelez ").println(saisie4, Color.RED);

		

		console.println("fin");
	}

}
