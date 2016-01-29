package br.com.home.help.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InformacaoClassificarDTO {

	private String recomendacao;

	private int nota;

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}
