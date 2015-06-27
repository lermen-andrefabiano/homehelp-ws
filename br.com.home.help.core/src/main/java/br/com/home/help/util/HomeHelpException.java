package br.com.home.help.util;

public class HomeHelpException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeHelpException(String chave) {
		super(chave);
	}

	public HomeHelpException(Throwable cause) {
		super(cause);
	}

	public HomeHelpException(String chave, Throwable cause) {
		super(chave, cause);
	}

}
