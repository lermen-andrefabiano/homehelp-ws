package br.com.home.help;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.Usuario;
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
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private EspecialidadeService especialidadeService;

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

	@Override
	public void incluir(Long usuarioId, Long especialidadeId, Long valorCobrado) {
		Usuario u = this.usuarioService.obterPorId(usuarioId);
		if(u!=null){
			if(u.getEspecialidades()==null){				
				u.setEspecialidades(new ArrayList<UsuarioEspecialidade>());
			}
			
			Especialidade e = this.especialidadeService.obterPorId(especialidadeId); 
			
			u.getEspecialidades().add(new UsuarioEspecialidade(valorCobrado, e, u));
			
			this.usuarioService.salvar(u);
		}
	}

}