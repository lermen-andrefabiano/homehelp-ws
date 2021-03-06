package br.com.home.help.core.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.home.help.core.enuns.TipoAgenda;

@Entity
@Table(schema = "homehelp")
public class Agenda implements Serializable {

    /**
     * This field is used to .....
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "homehelp.seq_agenda")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date data;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 1)
    private TipoAgenda status;

    @Column(length = 2000)
    private String observacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "chamado_id", referencedColumnName = "id", nullable = false)
    private Chamado chamado;

    @ManyToOne
    @JoinColumn(name = "re_agenda_id", referencedColumnName = "id")
    private Agenda reAgenda;

    public Agenda() {
    }

    public Agenda(Date data, TipoAgenda status, String observacao, Chamado chamado) {
        this.data = data;
        this.status = status;
        this.observacao = observacao;
        this.chamado = chamado;
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

    public TipoAgenda getStatus() {
        return status;
    }

    public void setStatus(TipoAgenda status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Agenda getReAgenda() {
        return reAgenda;
    }

    public void setReAgenda(Agenda reAgenda) {
        this.reAgenda = reAgenda;
    }

}
