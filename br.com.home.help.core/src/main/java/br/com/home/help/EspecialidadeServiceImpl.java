package br.com.home.help;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Especialidade;
import br.com.home.help.core.entidades.UsuarioEspecialidade;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class EspecialidadeServiceImpl implements EspecialidadeService {

    @Inject
    private EspecialidadeRepository especialidadeRep;

    @Override
    public Especialidade obterPorId(Long especialidadeId) {
        return especialidadeRep.obterPorId(especialidadeId);
    }

    @Override
    public Especialidade salvar(String descricao) {
        if (this.especialidadeRep.isNotEspecialidade(descricao)) {
            return this.especialidadeRep.salvar(new Especialidade(descricao));
        }
        return null;
    }

    @Override
    public List<UsuarioEspecialidade> listar(String str) {
        return this.especialidadeRep.listar(str);
    }

}