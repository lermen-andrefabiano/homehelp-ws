package br.com.home.help.core.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    
    @OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)  
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
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
