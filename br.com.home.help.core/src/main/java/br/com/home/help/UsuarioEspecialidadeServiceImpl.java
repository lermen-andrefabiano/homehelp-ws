package br.com.home.help;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.UsuarioEspecialidade;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class UsuarioEspecialidadeServiceImpl implements
		UsuarioEspecialidadeService {

	@Inject
	private UsuarioEspecialidadeRepository usuarioEspecialidadeRep;

	@Override
	public List<UsuarioEspecialidade> listar(String str) {
		return this.usuarioEspecialidadeRep.listar(str);
	}

	@Override
	public List<UsuarioEspecialidade> listarPorPrestador(Long prestadorId) {
		return this.usuarioEspecialidadeRep.listarPorPrestador(prestadorId);
	}

	@Override
	public void excluir(Long usuarioEspecialidadeId) {
		UsuarioEspecialidade u = this.usuarioEspecialidadeRep
				.obterPorId(usuarioEspecialidadeId);
		this.usuarioEspecialidadeRep.excluir(u);
	}

}