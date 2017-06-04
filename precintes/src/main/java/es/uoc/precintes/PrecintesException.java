package es.uoc.precintes;

public class PrecintesException extends Exception {

	/**
	 *  Classe que maneja les excepcions de l'aplicació
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	
	public PrecintesException (String key) {
		this.key=key;
	}
	
	public PrecintesException (String key, String message) {
		super(message);
		this.key=key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
