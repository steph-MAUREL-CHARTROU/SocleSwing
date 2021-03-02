package fr.diginamic.composants.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;

/** Champ de type texte pour saisir une information quelconque
 * @author RichardBONNAMY
 *
 */
public class TextField extends Input {
	
	/** Valeur saisie par l'utilisateur */
	private String value;

	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 */
	public TextField(String label, String name) {
		super(label, name);
		setWidth(150);
	}
	
	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 * @param value valeur du champ de saisie
	 */
	public TextField(String label, String name, String value) {
		super(label, name);
		this.value = value;
		setWidth(150);
	}
	

	@Override
	public JComponent convert() {
		return new JTextField();
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	@Override
	public void setValue(JComponent component) {
		this.value=((JTextField)component).getText();
	}

	@Override
	public InputType getType() {
		return InputType.TEXTFIELD;
	}


	
}
