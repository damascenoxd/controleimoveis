package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.TipoContato;

public interface TipoContatoRepository extends CrudRepository<TipoContato, Integer>{
	
	public TipoContato findById(Integer id);

}
