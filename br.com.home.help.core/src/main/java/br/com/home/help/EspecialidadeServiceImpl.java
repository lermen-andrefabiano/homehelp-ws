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

}