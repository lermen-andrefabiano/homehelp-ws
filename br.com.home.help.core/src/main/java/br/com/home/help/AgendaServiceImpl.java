package br.com.home.help;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Agenda;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class AgendaServiceImpl implements AgendaService {

	@Inject
	private AgendaRepository agendaRep;

	@Override
	public Agenda obterPorChamado(Long chamadoId) {
		return agendaRep.obterPorChamdo(chamadoId);
	}

}