package br.com.home.help.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InformacaoNotificarDTO {

	private String observacao;

	private String agendamento;

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(String agendamento) {
		this.agendamento = agendamento;
	}

}
