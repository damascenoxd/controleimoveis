package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Imovel;

public interface ImovelRepository extends CrudRepository<Imovel, Integer>{
	
	public Imovel findById(Integer id);

}
