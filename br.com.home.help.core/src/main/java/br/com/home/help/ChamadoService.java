package br.com.home.help;

import java.util.Date;
import java.util.List;

import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.core.enuns.TipoNota;
import br.com.home.help.core.enuns.TipoPrioridade;

/**
 * 
 * Home Help.
 *
 * @author: andre.lermen
 * @since: 23/06/2015
 *
 *         Change History
 *
 * @author: andre.lermen
 * @date: 23/06/2015
 * @reason: Initial code.
 *
 */
public interface ChamadoService {

	void abrir(String observacao, String descricao, TipoPrioridade prioridade,
			Long clienteId, Long prestadorId);

	void classificar(TipoNota nota, String recomendacao, Long clienteId,
			Long prestadorId, Long chamadoId);

	void alterar(Long chamadoId, String observacao, String descricao);

	void agendar(Long chamadoId, Date data, String observacao);

	void rejeitar(Long chamadoId);

	List<Chamado> listarPorCliente(Long clienteId);

	List<Chamado> listarPorPrestador(Long prestadorId);

}
