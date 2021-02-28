package fr.diginamic.composants.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;

public class ComboBox extends Input {

	private List<Selectable> selectables = new ArrayList<>();
	private String value;
	
	public ComboBox(String name, String label, List<Selectable> selectables) {
		super(name, label);
		this.selectables = selectables;
	}
	
	@Override
	public JComponent convert() {
		JComboBox<Selectable> combobox = new JComboBox<>();
		for (Selectable selectable: selectables) {
			combobox.addItem(selectable);
		}
		combobox.setEditable(true);
		return combobox;
	}

	@Override
	public String getValue() {
		return value;
	}
	
	@Override
	public void setValue(JComponent component) {
		this.value=((Selectable)((JComboBox<Selectable>)component).getSelectedItem()).getValue();
	}

	@Override
	public InputType getType() {
		return InputType.SELECT;
	}

	/**
	 * @return the selectables
	 */
	public List<Selectable> getSelectables() {
		return selectables;
	}

	/**
	 * @param selectables the selectables to set
	 */
	public void setSelectables(List<Selectable> selectables) {
		this.selectables = selectables;
	}

	

	
}
