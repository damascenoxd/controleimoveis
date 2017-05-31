package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Atendimento;

public interface AtendimentoRepository extends CrudRepository<Atendimento, Integer>{
	
	public Atendimento findById(Integer id);

}
