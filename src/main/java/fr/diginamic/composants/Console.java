package fr.diginamic.composants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import fr.diginamic.Launcher;

/**
 * Classe qui propose quelques méthodes pour construire des composants
 * graphiques
 * 
 * @author RichardBONNAMY
 *
 */
public class Console {

	/**
	 * FONT_18 : police par défaut utilisée pour la construction de tous les
	 * composants graphiques
	 */
	public static final Font FONT_18 = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
	/**
	 * dimension : classe qui fournit des informations sur l'écran du PC utilisé
	 * et notamment ses dimensions. Cette classe intervient dans le calcul de
	 * centrage des composants graphiques
	 */
	private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	/** texte du panneau d'affichage */
	private static StringBuilder contentpane = new StringBuilder();
	
	/** afficheur */
	public static JTextPane afficheur;

	/**
	 * Constructeur
	 * 
	 */
	public Console() {
	}

	/**
	 * Méthode utilitaire qui permet de calculer l'abscisse (X) idéale d'un
	 * composant graphique pour que celui-ci soit centré par rapport à l'écran de
	 * l'ordinateur utilisé.
	 * 
	 * @param component composant
	 * @return int
	 */
	public static int getY(Component component) {
		return (int) ((dimension.getHeight() - component.getHeight()) / 2);
	}

	/**
	 * Méthode utilitaire qui permet de calculer l'ordonnée (Y) idéale d'un
	 * composant graphique pour que celui-ci soit centré par rapport à l'écran de
	 * l'ordinateur utilisé.
	 * 
	 * @param component composant
	 * @return int
	 */
	public static int getX(Component component) {
		return (int) ((dimension.getWidth() - component.getWidth()) / 2);
	}

	public String input(String question) {
		
		JFrame fenetreRecherche = new JFrame("Question");

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

		// Lorsqu'on clique sur le bouton Valider on lance un système pour attendre la saisie
		// par l'utilisateur de la valeur demandée.
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				synchronized (Launcher.holder) {
					Launcher.holder.add(saisieField.getText());
					Launcher.holder.notify();
	            }
				fenetreRecherche.setVisible(false);
			}
		});
		fenetreRecherche.add(valider);
		fenetreRecherche.getRootPane().setDefaultButton(valider);
		fenetreRecherche.setVisible(true);
		
		synchronized (Launcher.holder) {
			// wait for input from field
			while (Launcher.holder.isEmpty()) {
				try {
					Launcher.holder.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			return Launcher.holder.remove(0);
		}
	}
	
	public Console html(String text) {
		contentpane.append(text);
		afficheur.setText(contentpane.toString());
		return this;
	}

	public Console print(String text) {
		contentpane.append(text);
		appendToPane(text, Color.BLACK);
		return this;
	}
	
	public Console println(String text) {
		contentpane.append(text).append("<br>");
		appendToPane(text + "\n", Color.BLACK);
		return this;
	}

	public Console print(String text, Color c) {
		contentpane.append("<span style='color:#").append(String.format("%02X", c.getRed())).append(String.format("%02X", c.getGreen())).append(String.format("%02X", c.getBlue())).append("'>").append(text).append("</span>");
		appendToPane(text, c);
		return this;
	}

	public Console println(String text, Color c) {
		contentpane.append("<span style='color:#").append(String.format("%02X", c.getRed())).append(String.format("%02X", c.getGreen())).append(String.format("%02X", c.getBlue())).append("'>").append(text).append("</span><br>");
		appendToPane(text + "\n", c);
		return this;
	}

	/** Ajoute du texte au conteneur
	 * @param msg message
	 * @param c couleur
	 * @return Console
	 */
	protected Console appendToPane(String msg, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

		int len = afficheur.getDocument().getLength();
		afficheur.setCaretPosition(len);
		afficheur.setCharacterAttributes(aset, false);
		afficheur.replaceSelection(msg);
		return this;
	}

	/**
	 * Efface le contenu de l'afficheur
	 */
	public void clear() {
		afficheur.setText("");
	}

}
