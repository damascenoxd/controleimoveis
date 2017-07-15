package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Integer>{
	
	public Estado findById(Integer id);

}
