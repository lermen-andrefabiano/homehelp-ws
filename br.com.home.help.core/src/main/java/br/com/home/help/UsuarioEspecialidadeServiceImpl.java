package br.com.home.help;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Especialidade;
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
	public List<UsuarioEspecialidade> getUsuarioEspecialidades(String str) {
		return this.usuarioEspecialidadeRep.getUsuarioEspecialidades(str);
	}

	@Override
	public List<UsuarioEspecialidade> getEspecialidaPrestador(Long prestadorId) {
		return this.usuarioEspecialidadeRep.getEspecialidaPrestador(prestadorId);
	}

	@Override
	public void excluir(Long usuarioEspecialidadeId) {
		UsuarioEspecialidade u = this.usuarioEspecialidadeRep.obterPorId(usuarioEspecialidadeId);
		this.usuarioEspecialidadeRep.excluir(u);
	}
	
	@Override
	public List<Especialidade> getEspecialidades(String especialidade) {
		List<Especialidade> lst = this.usuarioEspecialidadeRep.getEspecialidades(especialidade);
		return lst;		
	}

}