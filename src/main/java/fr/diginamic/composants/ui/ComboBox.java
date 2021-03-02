package fr.diginamic.composants.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;

/** Liste de sélection
 * @author RichardBONNAMY
 *
 */
public class ComboBox extends Input {

	/** Liste des options de la liste */
	private List<Selectable> selectables = new ArrayList<>();
	
	/** value */
	private Long id;
	
	/** Constructeur
	 * @param label libellé
	 * @param name nom
	 * @param selectables liste des options de la liste
	 */
	public ComboBox(String label, String name, List<Selectable> selectables) {
		super(label, name);
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
		return Long.toString(id);
	}
	
	@Override
	public void setValue(JComponent component) {
		this.id=((Selectable)((JComboBox<Selectable>)component).getSelectedItem()).getId();
	}

	@Override
	public InputType getType() {
		return InputType.SELECT;
	}

	/** Getter
	 * @return the selectables
	 */
	public List<Selectable> getSelectables() {
		return selectables;
	}

	/** Setter
	 * @param selectables the selectables to set
	 */
	public void setSelectables(List<Selectable> selectables) {
		this.selectables = selectables;
	}
}
