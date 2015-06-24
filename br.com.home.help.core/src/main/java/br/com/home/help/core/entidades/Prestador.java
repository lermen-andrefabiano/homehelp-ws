package br.com.home.help.core.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.home.help.core.enuns.TipoUsuario;

@Entity
@Table(schema = "homehelp")
public class Prestador extends Usuario {

    /**
     * This field is used to .....
     */
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Usuario usuario;

    @OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<PrestadorEspecialidade> especialidades;

    public Prestador() {
    }
    
    public Prestador(Long id) {
        super(id);
    }

    public Prestador(String nome, String alias, String login, String senha, TipoUsuario tipo) {
        super(nome, alias, login, senha, tipo);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<PrestadorEspecialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<PrestadorEspecialidade> especialidades) {
        this.especialidades = especialidades;
    }

}
