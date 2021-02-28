package fr.diginamic.composants.ui;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class DateField extends Input {
	
	private String value;

	public DateField(String name, String label) {
		super(name, label);
	}
	
	public DateField(String name, String label, int width) {
		super(name, label);
		setWidth(width);
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
		return InputType.DATEFIELD;
	}

	
}
