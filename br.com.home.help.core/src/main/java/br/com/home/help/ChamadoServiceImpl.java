package br.com.home.help;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Agenda;
import br.com.home.help.core.entidades.Chamado;
import br.com.home.help.core.entidades.ChamadoHistorico;
import br.com.home.help.core.entidades.Classificacao;
import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.Usuario;
import br.com.home.help.core.enuns.TipoAgenda;
import br.com.home.help.core.enuns.TipoNota;
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

	@Inject
	private UsuarioRepository usuarioRep;

	@Inject
	private EspecialidadeRepository especialidadeRep;

	@Override
	public void abrir(String descricao, Long usuarioId, Long prestadorId, Long especialidadeId) {
		Usuario usuario = usuarioRep.obterPorId(usuarioId);
		Usuario usuarioPestador = usuarioRep.obterPorId(prestadorId);
		Especialidade especialidade = especialidadeRep.obterPorId(especialidadeId);

		Chamado c = new Chamado(new Date(), descricao, TipoStatus.A, usuario, usuarioPestador, especialidade);

		List<ChamadoHistorico> historicos = new ArrayList<ChamadoHistorico>();

		historicos.add(new ChamadoHistorico(c.getData(), c.getStatus(), c));
		c.setHistoricos(historicos);

		this.chamadoRep.persist(c);
	}

	@Override
	public void alterar(Long chamadoId, String descricao) {
		Chamado c = this.chamadoRep.obterPorId(chamadoId);

		if (descricao != null) {
			c.setDescricao(descricao);
		}		

		c.getHistoricos().add(
				new ChamadoHistorico(new Date(), c.getStatus(), c));

		this.chamadoRep.salvar(c);

	}

	private void agendar(Long chamadoId, Date agendamento, String observacao) {
		Chamado c = this.chamadoRep.obterPorId(chamadoId);
		c.setStatus(TipoStatus.E);
		c.getHistoricos().add(new ChamadoHistorico(new Date(), c.getStatus(), c));

		this.chamadoRep.salvar(c);

		Agenda a = new Agenda(agendamento, TipoAgenda.A, observacao, c);

		this.agendaRep.persist(a);
	}

	private void rejeitar(Long chamadoId) {
		Chamado c = this.chamadoRep.obterPorId(chamadoId);
		c.setStatus(TipoStatus.R);
		c.getHistoricos().add(
				new ChamadoHistorico(new Date(), c.getStatus(), c));

		this.chamadoRep.salvar(c);
	}
	
	@Override
	public void notificar(Long chamadoId, String agendamento, String observacao) {		
		if(agendamento!=null && !agendamento.isEmpty()){			
			String[] agenda = agendamento.split("_");
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(agenda[0]));
			calendar.set(Calendar.MONTH, Integer.valueOf(agenda[1]+1));
			calendar.set(Calendar.YEAR, Integer.valueOf(agenda[2]));
			calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(agenda[3]));
			calendar.set(Calendar.MINUTE, Integer.valueOf(agenda[4]));
			
			this.agendar(chamadoId, calendar.getTime(), observacao);
		}else{
			this.rejeitar(chamadoId);
		}
	}

	@Override
	public void classificar(TipoNota nota, String recomendacao, Long chamadoId) {		
		Chamado chamado = chamadoRep.obterPorId(chamadoId);

		Classificacao c = new Classificacao(nota, recomendacao, chamado.getUsuario(), chamado.getPrestador(), chamado);

		c = this.classificaocaoRep.salvar(c);

		Chamado ch = this.chamadoRep.obterPorId(chamadoId);
		ch.setStatus(TipoStatus.F);
		ch.setClassificacao(c);
		ch.getHistoricos().add(new ChamadoHistorico(new Date(), ch.getStatus(), ch));

		this.chamadoRep.salvar(ch);
		
		this.atualizarAgenda(chamadoId);
	}

	private void atualizarAgenda(Long chamadoId) {
		Agenda a = this.agendaRep.obterPorChamdo(chamadoId);
		if(a!=null){
			a.setStatus(TipoAgenda.F);
			this.agendaRep.salvar(a);
		}		
	}

	@Override
	public List<Chamado> listarPorUsuario(Long usuarioId) {
		return this.chamadoRep.listarPorUsuario(usuarioId);
	}

	@Override
	public List<Chamado> listarChamadosAbertos(Long usuarioId) {
		return this.chamadoRep.listarChamadosAbertos(usuarioId);
	}

}