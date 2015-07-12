package br.com.home.help;

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
			Long usuarioId, Long prestadorId, Long especialidadeId);

	void classificar(TipoNota nota, String recomendacao, Long chamadoId);

	void alterar(Long chamadoId, String observacao, String descricao);

	void notificar(Long chamadoId, String agendamento, String observacao);

	List<Chamado> listarPorUsuario(Long usuarioId);

	List<Chamado> listarChamadosAbertos(Long usuarioId);

}
