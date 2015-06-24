package br.com.home.help.core.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.home.help.core.enuns.TipoUsuario;

@Entity
@Table(schema = "homehelp")
public class Cliente extends Usuario {

    /**
     * This field is used to .....
     */
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(Long id) {
        super(id);
    }

    public Cliente(String nome, String alias, String login, String senha, TipoUsuario tipo) {
        super(nome, alias, login, senha, tipo);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
