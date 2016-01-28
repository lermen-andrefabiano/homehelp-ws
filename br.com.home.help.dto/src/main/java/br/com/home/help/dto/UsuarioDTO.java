package br.com.home.help.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuario")
public class UsuarioDTO {

	private Long id;

	private String nome;

	private String email;

	private String login;

	private String endereco;

	private Boolean prestaServico;

	//private List<UsuarioEspecialidadeDTO> especialidades;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Boolean getPrestaServico() {
		return prestaServico;
	}

	public void setPrestaServico(Boolean prestaServico) {
		this.prestaServico = prestaServico;
	}

//	public List<UsuarioEspecialidadeDTO> getEspecialidades() {
//		return especialidades;
//	}
//
//	public void setEspecialidades(List<UsuarioEspecialidadeDTO> especialidades) {
//		this.especialidades = especialidades;
//	}
}
