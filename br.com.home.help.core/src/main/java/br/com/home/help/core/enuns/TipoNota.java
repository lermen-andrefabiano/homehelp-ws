package br.com.home.help.core.enuns;

public enum TipoNota {

	CINCO(5),

	SEIS(6),

	SETE(7),

	OITO(8),

	NOVE(9),

	DEZ(10);

	private int value;

	TipoNota(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
