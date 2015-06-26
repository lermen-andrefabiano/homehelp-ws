package br.com.home.help;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.core.entidades.Prestador;
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
    public boolean abrir(String observacao, String descricao, TipoPrioridade prioridade, Cliente cliente, Prestador prestador) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean alterar(String observacao, String descricao, TipoStatus tipoStatus, TipoPrioridade prioridade, Cliente cliente,
            Prestador prestador) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean agendar(Date data, String observacao, Long chamadoId, TipoStatus tipoStatus) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void classificar(TipoNota nota, String recomendacao, Long clienteId, Long prestadorId, Long chamadoId) {
        // TODO Auto-generated method stub
        
    }

   


}