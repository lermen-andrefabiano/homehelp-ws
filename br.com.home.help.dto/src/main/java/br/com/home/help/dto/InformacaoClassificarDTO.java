package br.com.home.help.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InformacaoClassificarDTO {

	private String recomendacao;

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}

}
