package fr.diginamic.composants.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JComponent;

import org.jdesktop.swingx.JXDatePicker;

public class DateField extends Input {
	
	private String value;
	private String format;
	private JXDatePicker picker;

	public DateField(String name, String label) {
		super(name, label);
		this.format="dd/MM/yyyy";
		setWidth(150);
	}
	
	@Override
	public JComponent convert() {
		picker = new JXDatePicker(Locale.FRANCE);
		picker.setFormats(new SimpleDateFormat(format));
		return picker;
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	@Override
	public void setValue(JComponent component) {
		String texte = picker.getEditor().getText();
		if (!texte.isEmpty()) {
			Date date = (Date)picker.getEditor().getValue();
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			this.value = formatter.format(date);
		}
	}
	
	@Override
	public InputType getType() {
		return InputType.DATEFIELD;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	
}
