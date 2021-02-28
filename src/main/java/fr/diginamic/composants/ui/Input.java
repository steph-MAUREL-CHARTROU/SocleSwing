package fr.diginamic.composants.ui;

import javax.swing.JComponent;

public abstract class Input {
	
	private String name;
	private String label;
	private int width;

	public Input(String name, String label) {
		super();
		this.name = name;
		this.label = label;
	}

	public abstract String getValue();
	
	public abstract void setValue(JComponent value);
	
	public abstract InputType getType();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}
