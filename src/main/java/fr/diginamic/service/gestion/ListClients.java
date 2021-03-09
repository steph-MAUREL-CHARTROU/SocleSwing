package fr.diginamic.service.gestion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.composants.validator.DeleteValidator;
import fr.diginamic.composants.validator.ValidatorClientForm;
import fr.diginamic.entite.Adresse;
import fr.diginamic.entite.Client;
import fr.diginamic.daos.ClientDao;

/**
 * 
 * @author StephanieMC
 *
 */

public class ListClients extends MenuService {

	public void traitement() {

		console.clear();
		console.println("<h1 class='bg-green'><center>Liste des clients</center></h1>");
		ClientDao clientDao = new ClientDao();

		List<Client> clients = clientDao.findAllClients();
		String html = "<table cellspacing=0 class='table'>"
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Nom</td><td>Prénom</td></tr>";
		for (Client c : clients) {
			html += "<tr>" + " "
					+ " <td><a class='btn-blue' href='update(" + c.getIdClient() + ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ "  <td><a class='btn-red' href='delete(" + c.getIdClient()+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>"
					+ " <td width='150px'>" + c.getNom()+ "</td>"
					+ "  <td width='150px'>" + c.getPrenom() + "</td>"
					+  "  <td width='150px'>" + c.getAdresse().getNumRue() + "</td>"
					+  "  <td width='150px'>" + c.getAdresse().getLibelleRue() + "</td>"
					+ "  <td width='150px'>" + c.getAdresse().getCodePostal() + "</td>"
					+ "  <td width='150px'>" + c.getAdresse().getNumTel() +"</td>"
					+ "  <td width='150px'>" + c.getAdresse().getEmail() + "</td>" + "</tr>";
		}
		html += "</table>";

		console.print(html);
	}

	protected void update(Long id) {

		ClientDao clientDao = new ClientDao();

		Form updateForm = new Form();

		Client c = clientDao.findById(id);

		updateForm.addInput(new TextField("Nom:", "nomClient", c.getNom()));
		updateForm.addInput(new TextField("Prénom:", "prenomClient", c.getPrenom()));
		updateForm.addInput(new TextField("N° de la voie :", "numVoie", Integer.toString(c.getAdresse().getNumRue())));
		updateForm.addInput(new TextField(" Libellé  :", "libelleVoie", c.getAdresse().getLibelleRue() ));
		updateForm.addInput(new TextField("Code Postal :", "cp", Integer.toString(c.getAdresse().getCodePostal())));
		updateForm.addInput(new TextField("N° Tel :", "numTel", c.getAdresse().getNumTel()));
		updateForm.addInput(new TextField("Email :", "email", c.getAdresse().getEmail() ));

		

		ValidatorClientForm validateFormClient = new ValidatorClientForm();

		boolean valide = console.input("Modification du client " + c.getPrenom() + " " + c.getNom(), updateForm,
				validateFormClient);
		
			String nvNom = updateForm.getValue("nomClient");
			String nvPrenom = updateForm.getValue("prenomClient");
			String nvNum = updateForm.getValue("numVoie");
			String nvLibelle = updateForm.getValue("libelleVoie");
			String nvCp = updateForm.getValue("cp");
			String nvTel = updateForm.getValue("numTel");
			String nvEmail = updateForm.getValue("email");
			
			c.setNom(nvNom);
			c.setPrenom(nvPrenom);
			c.getAdresse().setNumRue(Integer.parseInt(nvNum));
			c.getAdresse().setLibelleRue(nvLibelle);
			c.getAdresse().setCodePostal(Integer.parseInt(nvCp));
			c.getAdresse().setNumTel(nvTel);
			c.getAdresse().setEmail(nvEmail);
			

			clientDao.updateClient(c);

			traitement();

		}


	protected void delete(Long id) {

		ClientDao clientDao = new ClientDao();

		Form deleteForm = new Form();

		Client c = clientDao.findById(id);


		deleteForm.addInput(new TextField("Nom:", "nomClient", c.getNom()));
		deleteForm.addInput(new TextField("Prénom:", "prenomClient", c.getPrenom()));

	DeleteValidator validateDeleteClient= new DeleteValidator();

		boolean valide = console.input("suppression du client " + c.getPrenom() + " " + c.getNom(), deleteForm,
				validateDeleteClient);
		if (valide) {

			String nvNom = deleteForm.getValue("nomClient");
			String nvPrenom = deleteForm.getValue("prenomClient");
			c.setNom(nvNom);
			c.setPrenom(nvPrenom);

			clientDao.deleteClient(c);

			traitement();
		}

	}

}
