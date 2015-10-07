package br.com.home.help.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "especialidades")
public class UsuarioEspecialidadeDTO {

	private Long id;

	private Long valorCobrado;

	private EspecialidadeDTO especialidade;

	private String usuario;
	
	@Override
	public String toString() {
		return usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(Long valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public EspecialidadeDTO getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeDTO especialidade) {
		this.especialidade = especialidade;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
