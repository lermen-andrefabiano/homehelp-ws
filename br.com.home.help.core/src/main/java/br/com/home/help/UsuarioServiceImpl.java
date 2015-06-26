package br.com.home.help;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Cliente;
import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.core.entidades.PrestadorEspecialidade;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class UsuarioServiceImpl implements UsuarioService, PrestadorService {

    @Inject
    private ClienteRepository clienteRep;

    @Inject
    private PrestadorRepository prestadorRep;

    @Inject
    private PrestadorEspecialidadeRepository prestadorEspecialidadeRep;

    @Override
    public void login(String login, String senha, Boolean prestaServico) {
    }

    @Override
    public void criar(String nome, String alias, String login, String senha, Boolean prestaServico) {
        if(prestaServico){
            this.prestadorRep.persist(new Prestador(nome, alias, login, senha, prestaServico));
        }else{ 
            this.clienteRep.persist(new Cliente(nome, alias, login, senha, prestaServico));
        }
    }

    @Override
    public void addEspecialidade(Long valorCobrado, Long especialidadeId, Long prestadorId) {
        this.prestadorEspecialidadeRep.persist(new PrestadorEspecialidade(valorCobrado, new Especialidade(especialidadeId), 
                new Prestador(prestadorId)));
    }

}