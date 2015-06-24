package br.com.home.help.core.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
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
    
    @Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "homehelp.seq_prestador")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Usuario usuario;
    
    @OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)  
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<PrestadorEspecialidade> especialidades;

    public Prestador() {
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
