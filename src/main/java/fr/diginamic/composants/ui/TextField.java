package fr.diginamic.composants.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class TextField extends Input {
	
	private String value;

	public TextField(String name, String label) {
		super(name, label);
		setWidth(150);
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
