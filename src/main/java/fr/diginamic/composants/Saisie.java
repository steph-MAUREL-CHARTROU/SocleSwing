package fr.diginamic.composants;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Saisie {

	private Future<String> future;
	private String value;
	private boolean done;
	
	public Saisie() {
	}

	public String get() {
		while (future==null || !future.isDone()) {
			try {
				Thread.sleep(10L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	/** Getter
	 * @return the future
	 */
	public Future<String> getFuture() {
		return future;
	}

	/** Setter
	 * @param future the future to set
	 */
	public void setFuture(Future<String> future) {
		this.future = future;
	}

	/** Getter
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/** Setter
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/** Getter
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/** Setter
	 * @param done the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}
}
