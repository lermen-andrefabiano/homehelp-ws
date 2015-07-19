package br.com.home.help;

import br.com.home.help.core.entidades.Especialidade;

interface EspecialidadeRepository {

	Especialidade obterPorId(Long id);

	Especialidade salvar(Especialidade obj);

	void persist(Especialidade obj);

	void excluir(Especialidade obj);

	boolean isNotEspecialidade(String descricao);

}
