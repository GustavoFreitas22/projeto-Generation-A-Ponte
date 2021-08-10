package com.aponte.APonte.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.aponte.APonte.model.UserLogin;
import com.aponte.APonte.model.Usuario;
import com.aponte.APonte.repository.UsuarioRepository;


/**
 * Essa classe serve para realizar toda a regra de controler no usuário.
 * Logo o repository é injetado nela e ela é injetada no controller.*/

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		
		if(repository.findByUsuario(usuario.getUsuario()).isPresent()) { // Verifica se o user já existe
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User já existe", null);
			/**
			 * Quando uma Exception é lançada, o programa para a execução.
			 **/
		}
		if(repository.findByRegistro(usuario.getRegistro()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registro já existe", null);
			
			/**
			 * Verifica o registro*/
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // Objeto que criptografa as senhas

		String senhaEncoder = encoder.encode(usuario.getSenha()); // Var aux para inserir senha encriptada
		usuario.setSenha(senhaEncoder); // substituindo senha normal pela criptografada

		return repository.save(usuario); // salvando no banco de dados
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUserName());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {  // o matches faz o comparativo da senhas digitada no front para senha criptografada no banco

				String auth = user.get().getUserName() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);				
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());

				return user;

			}
		}
		return Optional.ofNullable(null);
	}

}