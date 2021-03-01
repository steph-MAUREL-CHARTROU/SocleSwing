package fr.diginamic.services;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.diginamic.composants.MenuService;

/**
 * Exemple
 * 
 * @author rbonn
 *
 */
public class LinkService extends MenuService {

	@Override
	public void traitement() {
		
		Image image = null;
		try {
		
		console.html("<h1 class='bg-green'><center>Liste des véhicules</center></h1>");
		console.html("<table cellspacing=0>"
				+ "<tr class='bg-green'><td class=''>&nbsp;</td><td class=''>&nbsp;</td><td class=''>Immatriculation</td></tr>"
				+ "<tr><td><a class='btn-blue' href='linkService.modifier(22)'><img src='"+getClass().getClassLoader().getResource("images/pencil-blue.png").toString()+"'></a></td><td><a class='btn-red' href='linkService.supprimer(22)'><img src='"+getClass().getClassLoader().getResource("images/trash-red.png").toString()+"'></a></td><td>Véhicule CV-HR-123</td></tr>"
				+ "<tr><td><a class='btn-blue' href='linkService.modifier(23)'><img src='"+getClass().getClassLoader().getResource("images/pencil-blue.png").toString()+"'></a></td><td><a class='btn-red' href='linkService.supprimer(23)'><img src='"+getClass().getClassLoader().getResource("images/trash-red.png").toString()+"'></a></td><td>Véhicule CV-HR-123</td></tr>"
				+ "</table>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void modifier(Long id) {
		console.html("Modification de l'item " + id);
	}

	public void supprimer(Long id) {
		console.html("Suppression de l'item " + id);
	}

}
