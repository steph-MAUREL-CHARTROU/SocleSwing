package fr.diginamic.composants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.google.common.util.concurrent.SettableFuture;

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
	 * dimension : classe qui fournit des informations sur l'écran du PC utilisé et
	 * notamment ses dimensions. Cette classe intervient dans le calcul de centrage
	 * des composants graphiques
	 */
	private static Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

	/** afficheur */
	public static JTextPane afficheur;
	
	private static ExecutorService threadService = Executors.newFixedThreadPool(3);

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

	public static Saisie input(String question) {

		// Création de la fenêtre secondaire
		Saisie saisie = new Saisie();
		TraitementSaisie tt = new TraitementSaisie(question, saisie);
		Future<String> future = threadService.submit(tt);
		
		
		saisie.setFuture(future);
		return saisie;
	}

	public Console print(String text) {
		appendToPane(text, Color.BLACK);
		return this;
	}
	
	public Console print(Saisie text) {
		
		Traitement tt = new Traitement(text);
		threadService.submit(tt);
		return this;
	}

	public Console println(String text) {
		appendToPane(text + "\n", Color.BLACK);
		return this;
	}

	public Console print(String text, Color c) {
		appendToPane(text, c);
		return this;
	}

	public Console println(String text, Color c) {
		appendToPane(text + "\n", c);
		return this;
	}

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

}
