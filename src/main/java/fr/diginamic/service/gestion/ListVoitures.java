package fr.diginamic.service.gestion;

import java.util.List;

import fr.diginamic.composants.MenuService;
/**
 * 
 * @author StephanieMC
 *
 */
import fr.diginamic.daos.VoitureDao;
import fr.diginamic.entite.Voiture;

public class ListVoitures extends MenuService {
	
	public void traitement() {

		console.clear();
		console.println("<h1 class='bg-green'><center>Liste des clients</center></h1>");
		VoitureDao voitureDao = new VoitureDao();

		List<Voiture> voitures = voitureDao.findAllCars();
		String html = "<table cellspacing=0 class='table'>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Nom</td><td>Prénom</td></tr>";
		for (Voiture v : voitures) {
			html += "<tr>" + " "
					+ " <td><a class='btn-blue' href='update(" + v.getIdVehicule() + ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ "  <td><a class='btn-red' href='delete(" + v.getIdVehicule()+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>"
					+ " <td width='150px'>" + v.getModeleVehicule()+ "</td>"
					+ "  <td width='150px'>" + v.getImmatriculation() + "</td>"
					+  "  <td width='150px'>" +v.getKilometrage() + "</td>"
					+  "  <td width='150px'>" + v.getNombrePlace() + "</td>"
					+ "  <td width='150px'>" + v.getStatutVehicule() + "</td>"
					 + "</tr>";
		}
		html += "</table>";

		console.print(html);
	}

}
