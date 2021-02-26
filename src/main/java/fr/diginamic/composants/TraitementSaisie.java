package fr.diginamic.composants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TraitementSaisie implements Callable<String> {
	
	private String question;
	private Saisie saisie;
	public TraitementSaisie(String question, Saisie saisie) {
		this.question=question;
		this.saisie=saisie;
	}

	/**
	 * Obligation de rédéfinir la méthode call. 
	 * Comme la classe Traitement1 implémente Call<Integer> alors
	 * la méthode call() doit retourner un résultat de type Integer
	 */
	@Override
	public String call() throws Exception {
		JFrame fenetreRecherche = new JFrame();

		// Calcul de son positionnement par défaut et de ses dimensions.
		// La hauteur dépend notamment du nombre de questions qu'on a à poser
		// à l'utilisateur
		fenetreRecherche.setBounds(100, 100, 650, 130);

		// Lorsqu'on ferme une fenêtre secondaire on ne souhaite pas arrêter
		// l'application
		// mais simplement la masquer.
		fenetreRecherche.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Dans chaque fenêtre secondaire les composants graphiques seront positionnés
		// en coordonnées x,y d'où la suppression du layout
		fenetreRecherche.getContentPane().setLayout(null);

		// Par défaut les fenêtres secondaires ne sont pas visibles.
		fenetreRecherche.setVisible(false);

		// Calcul des coordonnées x et y pour que la fenêtre secondaire soit centrée.
		int x = Console.getX(fenetreRecherche);
		int y = Console.getY(fenetreRecherche);
		fenetreRecherche.setLocation(x, y);

		// On réalise une boucle sur le tableau de questions pour générer et positionner
		// les divers éléments sur la fenêtre secondaire
		int maxWidth = 0;

		// Nombre de carcatères dans le texte de la question
		int nbCaracteres = question.length();

		// Largeur approximative en pixels du texte à afficher
		int largeurLabel = nbCaracteres * 10;

		// Création du label
		JLabel labelSaisie = new JLabel(question);
		labelSaisie.setBounds(10, 12, largeurLabel, 20);
		labelSaisie.setFont(Console.FONT_18);
		fenetreRecherche.add(labelSaisie);

		// Recherche du texte le plus large parmi tous les textes des questions
		if (largeurLabel > maxWidth) {
			maxWidth = largeurLabel;
		}

		// On fait une seconde boucle pour générer les champs de saisie.
		// Ces champs de saisie seront tous aligner à gauche.
		// Le positionnement X est le même pour tous les champs de saisie: maxWidth+5
		JTextField	saisieField = new JTextField();
		saisieField.setBounds(maxWidth + 5, 6, fenetreRecherche.getWidth() - maxWidth - 40, 30);
		saisieField.setFont(Console.FONT_18);
		fenetreRecherche.add(saisieField);

		// Création du bouton Valider
		JButton valider = new JButton("Valider");
		valider.setBounds(260, 45, 75, 25);

		// Lorsqu'on clique sur le bouton Valider on appelle
		// la méthode executeUseCase du contrôleur avec toutes les saisies effectuées
		// par l'utilisateur en paramètres de la méthode.
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display/center the jdialog when the button is pressed
				
				saisie.setValue(saisieField.getText());
				saisie.setDone(true);
				fenetreRecherche.setVisible(false);
			}
		});
		fenetreRecherche.add(valider);
		fenetreRecherche.getRootPane().setDefaultButton(valider);
		fenetreRecherche.setVisible(true);
		
		while (!saisie.isDone()) {
			Thread.sleep(10);
		}
		
		return saisieField.getText();
	}

}