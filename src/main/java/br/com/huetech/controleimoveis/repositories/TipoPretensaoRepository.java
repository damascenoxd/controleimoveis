package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.TipoPretensao;

public interface TipoPretensaoRepository extends CrudRepository<TipoPretensao, Integer>{
	
	public TipoPretensao findById(Integer id);

}
