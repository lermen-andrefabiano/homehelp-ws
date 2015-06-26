package br.com.home.help;

import java.util.Date;

import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.core.enuns.TipoNota;
import br.com.home.help.core.enuns.TipoPrioridade;
import br.com.home.help.core.enuns.TipoStatus;

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

    boolean abrir(String observacao, String descricao, TipoPrioridade prioridade, Cliente cliente, Prestador prestador);

    boolean alterar(String observacao, String descricao, TipoStatus tipoStatus, TipoPrioridade prioridade, Cliente cliente,
            Prestador prestador);

    boolean agendar(Date data, String observacao, Long chamadoId, TipoStatus tipoStatus);

    void classificar(TipoNota nota, String recomendacao, Long clienteId, Long prestadorId, Long chamadoId);

}
