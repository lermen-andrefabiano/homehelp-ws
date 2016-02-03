package br.com.home.help;

import java.util.List;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.UsuarioEspecialidade;

interface UsuarioEspecialidadeRepository {

    UsuarioEspecialidade obterPorId(Long id);

    void persist(UsuarioEspecialidade obj);

    UsuarioEspecialidade salvar(UsuarioEspecialidade obj);

    void excluir(UsuarioEspecialidade obj);
    
    List<UsuarioEspecialidade> getUsuarioEspecialidades(String str);

	List<UsuarioEspecialidade> getEspecialidaPrestador(Long prestadorId);
	
	List<Especialidade> getEspecialidades(String especialidade);

}
