package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.huetech.controleimoveis.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
	
	public Endereco findById(Integer id);

}
