package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Telefone;

public interface TelefoneRepository extends CrudRepository<Telefone, Integer>{
	
	public Telefone findById(Integer id);

}
