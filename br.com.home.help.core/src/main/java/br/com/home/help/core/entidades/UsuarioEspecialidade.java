package br.com.home.help.core.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "homehelp")
public class UsuarioEspecialidade implements Serializable {

    /**
     * This field is used to .....
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "homehelp.seq_Prestador_especialidade")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(nullable = false, precision = 12, scale = 2)
    private Long valorCobrado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "especialidade_id", referencedColumnName = "id", nullable = false)
    private Especialidade especialidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    public UsuarioEspecialidade() {
    }

    public UsuarioEspecialidade(Long valorCobrado, Especialidade especialidade, Usuario usuario) {
        this.valorCobrado = valorCobrado;
        this.especialidade = especialidade;
        this.usuario = usuario;
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

}
