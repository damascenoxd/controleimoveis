package br.com.huetech.controleimoveis.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.huetech.controleimoveis.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	public Usuario findById(Integer id);

}
