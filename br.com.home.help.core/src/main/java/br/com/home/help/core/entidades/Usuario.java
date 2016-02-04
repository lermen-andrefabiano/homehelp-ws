package br.com.home.help.core.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(schema = "homehelp")
public class Usuario implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "homehelp.seq_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;

	@Column(nullable = false, length = 200)
	private String nome;

	@Column(nullable = false, length = 200, unique = true)
	private String email;

	@Column(nullable = false, length = 30, unique = true)
	private String login;

	@Column(nullable = false, length = 300)
	private String endereco;

	@Column(nullable = false, length = 30)
	private String senha;

	@Column(nullable = false)
	private Boolean prestaServico = Boolean.FALSE;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<UsuarioEspecialidade> especialidades;

	public Usuario() {
	}

	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario(String nome) {
		this.nome = nome;
	}

	public Usuario(String nome, String email, String login, String senha,
			String endereco, Boolean prestaServico) {
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.endereco = endereco;
		this.prestaServico = prestaServico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getPrestaServico() {
		return prestaServico;
	}

	public void setPrestaServico(Boolean prestaServico) {
		this.prestaServico = prestaServico;
	}

	public List<UsuarioEspecialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<UsuarioEspecialidade> especialidades) {
		this.especialidades = especialidades;
	}

}
