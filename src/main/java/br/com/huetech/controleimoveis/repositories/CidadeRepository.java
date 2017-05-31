package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Integer>{
	
	public Cidade findById(Integer id);

}
