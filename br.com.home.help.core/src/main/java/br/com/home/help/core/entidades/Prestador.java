package br.com.home.help.core.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(schema = "homehelp")
public class Prestador extends Usuario {

    /**
     * This field is used to .....
     */
    private static final long serialVersionUID = 1L;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "prestador")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<PrestadorEspecialidade> especialidades;

    public Prestador() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
