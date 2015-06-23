package br.com.home.help.core.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(schema = "homehelp")
public class Cliente extends Usuario {

    /**
     * This field is used to .....
     */
    private static final long serialVersionUID = 1L;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id")
    private Usuario usuario;

    public Cliente() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
