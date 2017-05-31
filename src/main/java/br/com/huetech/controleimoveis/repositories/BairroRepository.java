package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Bairro;

public interface BairroRepository extends CrudRepository<Bairro, Integer>{
	
	public Bairro findById(Integer id);

}
