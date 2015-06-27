package br.com.home.help;

import java.util.List;

import br.com.home.help.core.entidades.Chamado;

interface ChamadoRepository {

	Chamado obterPorId(Long id);

	void persist(Chamado obj);

	Chamado salvar(Chamado obj);

	void excluir(Chamado obj);

	List<Chamado> listarPorCliente(Long clienteId);

	List<Chamado> listarPorPrestador(Long prestadorId);

}
