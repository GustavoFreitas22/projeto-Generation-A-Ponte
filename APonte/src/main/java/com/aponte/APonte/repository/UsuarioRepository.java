package com.aponte.APonte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aponte.APonte.model.Usuario;

import java.util.*;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
	public Optional <Usuario> findByUsuario(String usuario);
	public Optional <Usuario> findByRegistro(String usuario);
	public Usuario findByNome(String nome);
}