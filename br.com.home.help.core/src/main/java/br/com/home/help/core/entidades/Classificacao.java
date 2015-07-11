package br.com.home.help.core.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.home.help.core.enuns.TipoNota;

@Entity
@Table(schema = "homehelp")
public class Classificacao implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "homehelp.seq_classificacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TipoNota nota;
	
	@Column(nullable = false, length = 2000)
	private String recomendacao;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
	private Usuario usuario;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "prestador_id", referencedColumnName = "id", nullable = false)
	private Usuario prestador;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Chamado chamado;

	public Classificacao() {
	}

	public Classificacao(TipoNota nota, String recomendacao, Usuario usuario,
			Usuario prestador, Chamado chamado) {
		this.nota = nota;
		this.recomendacao = recomendacao;
		this.usuario = usuario;
		this.prestador = prestador;
		this.chamado = chamado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoNota getNota() {
		return nota;
	}

	public void setNota(TipoNota nota) {
		this.nota = nota;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getPrestador() {
		return prestador;
	}

	public void setPrestador(Usuario prestador) {
		this.prestador = prestador;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

}
