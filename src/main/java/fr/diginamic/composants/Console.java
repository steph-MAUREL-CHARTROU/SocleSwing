package fr.diginamic.composants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import fr.diginamic.Launcher;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.Input;

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
	public static final Font FONT_10 = new Font(Font.SANS_SERIF, Font.PLAIN, 10);
	public static final Font FONT_12 = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
	public static final Font FONT_14 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
	public static final Font FONT_16 = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
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

	/**
	 * @param titreFormulaire
	 * @param form
	 * @return
	 */
	public boolean input(String titreFormulaire, Form form) {

		JFrame fenetreRecherche = new JFrame(titreFormulaire);

		// Lorsqu'on ferme une fenêtre secondaire on ne souhaite pas arrêter
		// l'application
		// mais simplement la masquer.
		fenetreRecherche.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Dans chaque fenêtre secondaire les composants graphiques seront positionnés
		// en coordonnées x,y d'où la suppression du layout
		fenetreRecherche.getContentPane().setLayout(null);

		// Par défaut les fenêtres secondaires ne sont pas visibles.
		fenetreRecherche.setVisible(false);

		// On réalise une boucle sur le tableau de questions pour générer et
		// positionner
		// les divers éléments sur la fenêtre secondaire

		Map<String, JComponent> fields = new HashMap<>();

		int maxWidth = 0;

		int maxInputWidth = 0;
		int maxLabelWidth = 0;
		for (Input input : form) {

			// Nombre de carcat�res dans le texte de la question
			int nbCaracteres = input.getLabel().length();

			// Largeur approximative en pixels du texte � afficher
			int largeurLabel = nbCaracteres * 10;

			// Recherche du texte le plus large parmi tous les textes des questions
			if (largeurLabel > maxLabelWidth) {
				maxLabelWidth = largeurLabel;
			}
			if (input.getWidth() > maxInputWidth) {
				maxInputWidth = input.getWidth();
			}
		}

		maxWidth = maxLabelWidth + maxInputWidth + 30;
		// Calcul de son positionnement par défaut et de ses dimensions.
		// La hauteur dépend notamment du nombre de questions qu'on a à poser
		// à l'utilisateur

		fenetreRecherche.setBounds(100, 100, maxWidth, 110 + 40 * (form.size() - 1));
		// Calcul des coordonnées x et y pour que la fenêtre secondaire soit centrée.
		int x = Console.getX(fenetreRecherche);
		int y = Console.getY(fenetreRecherche);
		fenetreRecherche.setLocation(x, y);

		for (int i = 0; i < form.getInputs().size(); i++) {

			Input input = form.getInputs().get(i);

			// Cr�ation du label
			JLabel label = new JLabel(input.getLabel());
			label.setBounds(10, 18 + i * 30, maxLabelWidth, 20);
			label.setFont(FONT_14);
			fenetreRecherche.add(label);

			JComponent component = input.convert();
			int width = fenetreRecherche.getWidth() - maxLabelWidth - 40;
			if (input.getWidth() > 0) {
				width = input.getWidth();
			}
			component.setBounds(maxLabelWidth + 5, 12 + i * 30, width, 30);
			component.setName(input.getName());

			component.setFont(FONT_14);
			fenetreRecherche.add(component);
			fields.put(form.getInputs().get(i).getName(), component);

		}

		// Création du bouton Valider
		
		JButton annuler = new JButton("Annuler");
		annuler.setBounds((maxWidth-170)/2, 40 + 40 * (form.size() - 1), 75, 25);
		
		JButton valider = new JButton("Valider");
		valider.setBounds((maxWidth-170)/2+95, 40 + 40 * (form.size() - 1), 75, 25);
		
		// Lorsqu'on clique sur le bouton Valider on lance un système pour attendre la
		// saisie
		// par l'utilisateur de la valeur demandée.
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				synchronized (Launcher.holder) {

					Launcher.holder.add(false);
					Launcher.holder.notify();
				}
				fenetreRecherche.setVisible(false);
			}
		});

		// Lorsqu'on clique sur le bouton Valider on lance un système pour attendre la
		// saisie
		// par l'utilisateur de la valeur demandée.
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				synchronized (Launcher.holder) {

					for (String name : fields.keySet()) {
						Input input = form.getInput(name);
						input.setValue(fields.get(name));
					}

					Launcher.holder.add(true);
					Launcher.holder.notify();
				}
				fenetreRecherche.setVisible(false);
			}
		});
		fenetreRecherche.add(annuler);
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
		contentpane.append("<span style='color:#").append(String.format("%02X", c.getRed()))
				.append(String.format("%02X", c.getGreen())).append(String.format("%02X", c.getBlue())).append("'>")
				.append(text).append("</span>");
		appendToPane(text, c);
		return this;
	}

	public Console println(String text, Color c) {
		contentpane.append("<span style='color:#").append(String.format("%02X", c.getRed()))
				.append(String.format("%02X", c.getGreen())).append(String.format("%02X", c.getBlue())).append("'>")
				.append(text).append("</span><br>");
		appendToPane(text + "\n", c);
		return this;
	}

	/**
	 * Ajoute du texte au conteneur
	 * 
	 * @param msg message
	 * @param c   couleur
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
