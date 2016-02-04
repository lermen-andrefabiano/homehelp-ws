package br.com.home.help;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.Usuario;
import br.com.home.help.core.entidades.UsuarioEspecialidade;
import br.com.home.help.test.spring.AbstractSpringTest;

public class TestUsuarioHibernate extends AbstractSpringTest {

	@Inject
	private UsuarioRepository usuarioRep;

	@Test
	public void obterPorId() {
		assertNotNull(this.usuarioRep.obterPorId(1L));
	}

	@Test
	public void salvarPrestador() {
		Usuario p = new Usuario();
		p.setNome("pedro da silva");
		p.setEmail("pedro@bol.com.br");
		p.setEndereco("av brasil");
		p.setLogin("pedro");
		p.setSenha("1234");
		p.setPrestaServico(Boolean.TRUE);

		List<UsuarioEspecialidade> especialidades = new ArrayList<UsuarioEspecialidade>();

		especialidades.add(new UsuarioEspecialidade(15L, new Especialidade(1L), p));
		especialidades.add(new UsuarioEspecialidade(10L, new Especialidade(2L), p));
		especialidades.add(new UsuarioEspecialidade(10L, new Especialidade(3L), p));
		especialidades.add(new UsuarioEspecialidade(10L, new Especialidade(4L), p));
		especialidades.add(new UsuarioEspecialidade(10L, new Especialidade(5L), p));

		p.setEspecialidades(especialidades);

		this.usuarioRep.persist(p);

	}

	@Test
	public void salvarUsuario() {
		Usuario c = new Usuario();
		c.setNome("andre fabiano lermen");
		c.setEmail("lermen.andre@bol.com.br");
		c.setEndereco("av brasil");
		c.setLogin("lermen");
		c.setSenha("1234");
		c.setPrestaServico(Boolean.FALSE);

		this.usuarioRep.persist(c);

	}
	
	@Test
	public void obterPrestador() {
		Usuario u = this.usuarioRep.obterPorId(2L);
		
		log.debug(u.getNome());
		
		if(u.getPrestaServico()){
			for(UsuarioEspecialidade up : u.getEspecialidades()){
				log.debug(up.getEspecialidade().getDescricao() + " " +up.getValorCobrado());
			}
		}
		
	}

	@Test
	public void excluir() {
		Usuario u = this.usuarioRep.obterPorId(3L);

		if (isResult(u, "excluir")) {
			this.usuarioRep.excluir(u);
		}

	}
	
	@Test
	public void obterPorEmail() {
		Usuario u = this.usuarioRep.obterPorEmail("home@home.com.br");

		if (isResult(u, "obterPorEmail")) {
			log.debug(u.getNome());
		}

	}
}
