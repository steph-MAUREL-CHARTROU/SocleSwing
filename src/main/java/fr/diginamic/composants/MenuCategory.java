package fr.diginamic.composants;

import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuCategory extends JMenuItem {

	/** serialVersionUID */
	private static final long serialVersionUID = 2204342394139209834L;

	private String name;

	public MenuCategory(String name) {
		super();
		this.name = name;
	}

	public void addMenu(String string, char ctrlChar) {
		JMenuItem menuItem = new JMenuItem(name);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(ctrlChar, KeyEvent.CTRL_DOWN_MASK));

		add(menuItem);

	}

	/**
	 * Getter
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
