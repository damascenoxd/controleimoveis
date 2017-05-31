package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
	
	public Cliente findById(Integer id);

}
