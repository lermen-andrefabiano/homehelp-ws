package br.com.home.help.core.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.home.help.core.enuns.TipoStatus;

@Entity
@Table(schema = "homehelp")
public class Chamado implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "homehelp.seq_chamado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;	

	@Column(nullable = false, length = 2000)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 1)
	private TipoStatus status;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "especialidade_id", referencedColumnName = "id", nullable = false)
	private Especialidade especialidade;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
	private Usuario usuario;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "prestador_id", referencedColumnName = "id", nullable = false)
	private Usuario prestador;

	@OneToOne(fetch = FetchType.LAZY)
	private Classificacao classificacao;

	@OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ChamadoHistorico> historicos;

	public Chamado() {
	}

	public Chamado(Long id) {
		this.id = id;
	}

	public Chamado(Date data, String descricao,	TipoStatus status, Usuario usuario,	Usuario prestador, Especialidade especialidade) {
		this.data = data;
		this.descricao = descricao;
		this.status = status;
		this.usuario = usuario;
		this.prestador = prestador;
		this.especialidade = especialidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
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

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public List<ChamadoHistorico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<ChamadoHistorico> historicos) {
		this.historicos = historicos;
	}

}
