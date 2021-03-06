package br.com.home.help;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.test.spring.AbstractSpringTest;

public class TestChamadoService extends AbstractSpringTest {

	@Inject
	private ChamadoService chamadoService;

	Long chamadoId = 1L;
	
	Long usuarioId = 1L;
	
	Long presatdorId = 2L;
	
	Long especialidaded = 5L;

	@Test
	public void abrir() {
		this.chamadoService.abrir("troca de torneira", usuarioId, presatdorId, especialidaded);
	}

	@Test
	public void alterar() {
		this.chamadoService.alterar(chamadoId, null);
	}	

	@Test
	public void classificar() {
		this.chamadoService.classificar(10, "recomendo", chamadoId);
	}

	@Test
	public void listarPorUsuario() {
		List<Chamado> lst = this.chamadoService.listarPorUsuario(usuarioId);

		for (Chamado c : lst) {
			log.debug(c.getId() +" "+c.getDescricao());
		}

	}

	@Test
	public void listarPorPrestador() {
		List<Chamado> lst = this.chamadoService.listarChamadosAbertos(presatdorId);

		for (Chamado c : lst) {
			log.debug(c.getId() +" "+c.getDescricao());
		}

	}

}
