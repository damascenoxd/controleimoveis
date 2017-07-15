package br.com.huetech.controleimoveis.models;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Usuario findById(Integer id);

}
