package br.com.home.help;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.Prestador;
import br.com.home.help.core.entidades.PrestadorEspecialidade;
import br.com.home.help.core.enuns.TipoUsuario;

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
    private PrestadorRepository PrestadorRep;

    @Inject
    private PrestadorEspecialidadeRepository prestadorEspecialidadeRep;

    @Override
    public void login(String login, String senha, TipoUsuario tipo) {
    }

    @Override
    public void criar(String nome, String alias, String login, String senha, TipoUsuario tipo) {
        if(tipo.equals(TipoUsuario.U)){
            
        }else if(tipo.equals(TipoUsuario.P)){
            
        }
    }

    @Override
    public void addEspecialidade(Long valorCobrado, Long especialidadeId, Long prestadorId) {
        this.prestadorEspecialidadeRep.persist(new PrestadorEspecialidade(valorCobrado, new Especialidade(especialidadeId), 
                new Prestador(prestadorId)));
    }

}