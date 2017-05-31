package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.CaracteristicaImovel;

public interface CaracteristicaImovelRepository extends CrudRepository<CaracteristicaImovel, Integer>{
	
	public CaracteristicaImovel findById(Integer id);

}
