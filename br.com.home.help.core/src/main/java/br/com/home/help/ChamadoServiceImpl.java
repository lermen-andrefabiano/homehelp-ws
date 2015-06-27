package br.com.home.help;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Agenda;
import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.core.entidades.ChamadoHistorico;
import br.com.home.help.core.entidades.Classificacao;
import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.core.enuns.TipoAgenda;
import br.com.home.help.core.enuns.TipoNota;
import br.com.home.help.core.enuns.TipoPrioridade;
import br.com.home.help.core.enuns.TipoStatus;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class ChamadoServiceImpl implements ChamadoService {

	@Inject
	private ChamadoRepository chamadoRep;

	@Inject
	private AgendaRepository agendaRep;

	@Inject
	private ClassificaocaoRepository classificaocaoRep;

	@Override
	public void abrir(String observacao, String descricao,
			TipoPrioridade prioridade, Long clienteId, Long prestadorId) {
		Chamado c = new Chamado(new Date(), observacao, descricao,
				TipoStatus.A, prioridade, new Cliente(clienteId),
				new Prestador(prestadorId));
		List<ChamadoHistorico> historicos = new ArrayList<ChamadoHistorico>();

		historicos.add(new ChamadoHistorico(c.getData(), c.getStatus(), c));
		c.setHistoricos(historicos);

		this.chamadoRep.persist(c);
	}

	@Override
	public void alterar(Long chamadoId, String observacao, String descricao) {
		Chamado c = this.chamadoRep.obterPorId(chamadoId);
		c.setDescricao(descricao);
		c.setObservacao(observacao);

		c.getHistoricos().add(
				new ChamadoHistorico(new Date(), c.getStatus(), c));

		this.chamadoRep.salvar(c);

	}

	@Override
	public void agendar(Long chamadoId, Date data, String observacao) {
		Chamado c = this.chamadoRep.obterPorId(chamadoId);
		c.setStatus(TipoStatus.E);
		c.getHistoricos().add(
				new ChamadoHistorico(new Date(), c.getStatus(), c));

		this.chamadoRep.salvar(c);

		Agenda a = new Agenda(data, TipoAgenda.A, observacao, c);

		this.agendaRep.persist(a);
	}

	@Override
	public void rejeitar(Long chamadoId) {
		Chamado c = this.chamadoRep.obterPorId(chamadoId);
		c.setStatus(TipoStatus.R);
		c.getHistoricos().add(
				new ChamadoHistorico(new Date(), c.getStatus(), c));

		this.chamadoRep.salvar(c);
	}

	@Override
	public void classificar(TipoNota nota, String recomendacao, Long clienteId,
			Long prestadorId, Long chamadoId) {
		Classificacao c = new Classificacao(nota, recomendacao, new Cliente(
				clienteId), new Prestador(prestadorId), new Chamado(chamadoId));

		c = this.classificaocaoRep.salvar(c);

		Chamado ch = this.chamadoRep.obterPorId(chamadoId);
		ch.setStatus(TipoStatus.F);
		ch.setClassificacao(c);
		ch.getHistoricos().add(
				new ChamadoHistorico(new Date(), ch.getStatus(), ch));

		this.chamadoRep.salvar(ch);

	}

	@Override
	public List<Chamado> listarPorCliente(Long clienteId) {
		return this.chamadoRep.listarPorCliente(clienteId);
	}

	@Override
	public List<Chamado> listarPorPrestador(Long prestadorId) {
		return this.chamadoRep.listarPorPrestador(prestadorId);
	}

}