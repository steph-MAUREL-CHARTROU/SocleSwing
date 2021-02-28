package fr.diginamic.composants.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class Select extends Input {

	private List<Selectable> liste = new ArrayList<>();
	
	private String value;
	
	public Select(String name, String label) {
		super(name, label);
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public void setValue(JComponent component) {
		this.value=null;
	}

	@Override
	public InputType getType() {
		return InputType.SELECT;
	}

	
	
}
