package br.com.home.help;

import java.util.List;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.UsuarioEspecialidade;

public interface UsuarioEspecialidadeService {

	List<UsuarioEspecialidade> getUsuarioEspecialidades(String str);

	List<UsuarioEspecialidade> getEspecialidaPrestador(Long prestadorId);

	void excluir(Long usuarioEspecialidadeId);

	List<Especialidade> getEspecialidades(String especialidade);

	void incluir(Long usuarioId, Long especialidadeId, Long valorCobrado);

}
