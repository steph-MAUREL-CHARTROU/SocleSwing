package fr.diginamic.composants;

import java.util.concurrent.Callable;

public class TraitementMenu implements Callable<String> {
	
	private MenuService menuService;
	public TraitementMenu(MenuService menuService) {
		this.menuService=menuService;
	}

	/**
	 * Obligation de rédéfinir la méthode call. 
	 * Comme la classe Traitement1 implémente Call<Integer> alors
	 * la méthode call() doit retourner un résultat de type Integer
	 */
	@Override
	public String call() throws Exception {
		menuService.traitement();
		return null;
	}

}