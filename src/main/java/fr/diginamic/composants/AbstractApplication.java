package fr.diginamic.composants;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public abstract class AbstractApplication extends JFrame {

	/** serialVersionUID */
	private static final long serialVersionUID = -5774337273803383053L;
	private int width = 1400;
	private int height = 718;
	
	private Map<Integer, JMenu> categories = new HashMap<>();
	private JMenuBar menuBar = new JMenuBar();
	private static ExecutorService threadService = Executors.newFixedThreadPool(3);

	/**
	 * Constructeur
	 * 
	 * @param title nom de l'application qui s'affiche dans le bandeau
	 */
	public AbstractApplication(String title) {
		setTitle(title);

		// Taille de la fenêtre
		setSize(width, height);

		// Opération à effectuer lorsque l'utilisateur clique sur la croix de fermeture:
		// EXIT_ON_CLOSE signifie arrêt de l'application
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// calcule de la position X de la fenêtre dans l'environnement windows
		int x = Console.getX(this);

		// calcule de la position Y de la fenêtre dans l'environnement windows
		int y = Console.getY(this);

		// Mise à jour des coordonnées de l'application dans l'environnement windows.
		// Le but recherché est que l'application soit centrée sur le PC au démarrage
		// Sinon par défaut l'application apparait en haut à gauche.
		setLocation(x, y);
	}
	
	public void addMenu(Integer id, String categoryName) {
		JMenu menuCateg = new JMenu(categoryName);
		menuBar.add(menuCateg);
		
		categories.put(id, menuCateg);
	}
	
	public void addMenuOption(Integer id, String name, MenuService menuService) {
		
		JMenu menuCateg = categories.get(id);
		if (menuCateg!=null) {
			JMenuItem menuItem = new JMenuItem(name);
			menuCateg.add(menuItem);
			menuItem.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					TraitementMenu tt = new TraitementMenu(menuService);
					threadService.submit(tt);
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					TraitementMenu tt = new TraitementMenu(menuService);
					threadService.submit(tt);
				}
			});
		}
	}

	/**
	 * Construit l'interface graphique principale avec:<br>
	 * - des boutons pour chaque item du menu<br>
	 * - un bouton/gomme permettant d'effacer la zone d'affichage<br>
	 * - une JTextPane qui va permettre d'afficher tout ce qu'on a à afficher.
	 * 
	 */
	public void buildInterfaceGraphique() {
		this.setLayout(null);

		// La mise à NULL du Layout permet d'afficher tous les éléments de l'interface
		// graphique en coordonnées X, Y

		// Création de l'afficheur qui sera ici un JTextPane.
		JTextPane afficheur = new JTextPane();
		afficheur.setBounds(10, 200, width - 40, 390);
		afficheur.setFont(Console.FONT_18);
		
		Console.afficheur = afficheur;

		// Création d'un JScrollPane qui va permettre d'ajouter des barres de défilement
		// horizontale et verticale avec curseurs à notre afficheur.
		JScrollPane sp = new JScrollPane(afficheur);
		sp.setBounds(10, 20, width - 40, 620);

		// On ajoute le JScrollPane à l'interface graphique.
		this.add(sp);
		
		// Ajout de la barre de menu
		this.setJMenuBar(menuBar);
		
		this.main();

		// On rend l'interface graphique visible par défaut, ce qui est préférable.
		this.setVisible(true);
	}
	
	
	public abstract void main();
}
