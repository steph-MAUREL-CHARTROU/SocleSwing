package fr.diginamic.composants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

import fr.diginamic.Application;

public abstract class AbstractApplication extends JFrame {

	/** serialVersionUID */
	private static final long serialVersionUID = -5774337273803383053L;
	private int width = 1400;
	private int height = 718;
	
	private Map<String, JMenu> categories = new HashMap<>();
	private JMenuBar menuBar = new JMenuBar();

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
	
	public void addMenuCategory(String categoryName, char mnemonic) {
		JMenu menuCateg = new JMenu(categoryName);
		menuCateg.setMnemonic(mnemonic);
		menuBar.add(menuCateg);
		
		categories.put(categoryName, menuCateg);
	}
	
	public void addMenuOption(String categoryName, String name, char ctrlChar, MenuService menuService) {
		
		JMenu menuCateg = categories.get(categoryName);
		if (menuCateg!=null) {
			JMenuItem menuItem = new JMenuItem(name);
			menuItem.setAccelerator( KeyStroke.getKeyStroke(ctrlChar, KeyEvent.CTRL_DOWN_MASK) );
			
			menuCateg.add(menuItem);
			menuItem.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					menuService.traitement();
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					menuService.traitement();
					
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
		sp.setBounds(10, 270, width - 40, 390);

		// On ajoute le JScrollPane à l'interface graphique.
		this.add(sp);

		// Ajout du bouton en forme de gomme
		ImageIcon image = new ImageIcon(Application.class.getResource("/gomme.png"));
		JButton boutonGomme = new JButton(image);
		boutonGomme.setBounds(width - 62, 236, 30, 30);

		// Ajout d'un listener sur le bouton. Ce listener permet de déclencher une
		// action lorsque l'utilisateur clique sur le bouton.
		boutonGomme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// L'action ici est d'effacer le contenu de l'afficheur
				afficheur.setText("");
			}
		});

		// Ajout du bouton en forme de gomme à l'interface graphique
		this.add(boutonGomme);
		
		// Ajout de la barre de menu
		this.setJMenuBar(menuBar);
		
		this.main();

		// On rend l'interface graphique visible par défaut, ce qui est préférable.
		this.setVisible(true);
	}
	
	
	public abstract void main();
}
