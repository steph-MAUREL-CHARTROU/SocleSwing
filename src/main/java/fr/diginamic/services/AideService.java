package fr.diginamic.services;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import fr.diginamic.composants.Console;
import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.Saisie;

public class AideService extends MenuService {

	@Override
	public void traitement() {
		console.println("Bonjour");

		Saisie saisie = Console.input("Comment vous appelez-vous ?");
		
		Future<String> future = saisie.getFuture();
		while (!future.isDone()) {
			
		}

		try {
			console.println("Vous vous appelez ").print(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		console.println("fin");
	}

}
