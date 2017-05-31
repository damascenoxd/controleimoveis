package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{
	
	public Endereco findById(Integer id);

}
