package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.huetech.controleimoveis.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	public Cliente findById(Integer id);
	
	
}
