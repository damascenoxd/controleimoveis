package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.TipoImovel;

public interface TipoImovelRepository extends CrudRepository<TipoImovel, Integer>{
	
	public TipoImovel findById(Integer id);

}
