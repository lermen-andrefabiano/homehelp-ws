package br.com.home.help;

import java.util.List;

import br.com.home.help.core.entidades.UsuarioEspecialidade;

public interface UsuarioEspecialidadeService {

	List<UsuarioEspecialidade> listar(String str);

	List<UsuarioEspecialidade> listarPorPrestador(Long prestadorId);

	void excluir(Long usuarioEspecialidadeId);

}
