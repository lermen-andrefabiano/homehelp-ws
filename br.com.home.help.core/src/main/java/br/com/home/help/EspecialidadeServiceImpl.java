package br.com.home.help;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.home.help.core.entidades.Especialidade;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class EspecialidadeServiceImpl implements EspecialidadeService {

    @Inject
    private EspecialidadeRepository especialidadeRep;
   
//    public EspecialidadeServiceImpl(EspecialidadeRepository especialidadeRep) {
//        this.especialidadeRep = especialidadeRep;
//    }

    @Override
    public Especialidade obterPorId(Long especialidadeId) {
        return especialidadeRep.obterPorId(especialidadeId);
    }

    @Override
    public Especialidade salvar(Especialidade especialidade) {
        return especialidadeRep.salvar(especialidade);
    }

    @Override
    public void excluir(Long especialidadeId) {
        Especialidade especialidade = this.obterPorId(especialidadeId);
        this.especialidadeRep.excluir(especialidade);
    }

}