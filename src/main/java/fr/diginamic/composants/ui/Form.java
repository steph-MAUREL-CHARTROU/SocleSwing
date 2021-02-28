package fr.diginamic.composants.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Form implements Iterable<Input> {

	private List<Input> inputs = new ArrayList<>();
	
	public Input getInput(String name) {
		Optional<Input> optional = inputs.stream().filter(i -> i.getName().equals(name)).findFirst();
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	/**
	 * @return the inputs
	 */
	public List<Input> getInputs() {
		return inputs;
	}

	/**
	 * @param inputs the inputs to set
	 */
	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}

	public void addInput(Input input) {
		inputs.add(input);
	}

	public String getValue(String name) {
		
		return getInput(name).getValue();
	}

	public int size() {
		return inputs.size();
	}

	@Override
	public Iterator<Input> iterator() {
		return inputs.iterator();
	}
	
}
