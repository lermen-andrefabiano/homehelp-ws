package br.com.home.help;

import br.com.home.help.core.entidades.Agenda;

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
public interface AgendaService {

	Agenda obterPorChamado(Long chamadoId);

}
