package fr.diginamic.composants;

import java.awt.Color;
import java.util.concurrent.Callable;

public class Traitement implements Callable<Void> {
	
	/** console */
	private Console console = new Console();
	private Saisie saisie;
	
	public Traitement(Saisie saisie) {
		this.saisie=saisie;
	}

	/**
	 * Obligation de rédéfinir la méthode call. 
	 * Comme la classe Traitement1 implémente Call<Integer> alors
	 * la méthode call() doit retourner un résultat de type Integer
	 */
	@Override
	public Void call() throws Exception {
		
		console.print(saisie.get(), Color.RED);
		return null;
	}

}