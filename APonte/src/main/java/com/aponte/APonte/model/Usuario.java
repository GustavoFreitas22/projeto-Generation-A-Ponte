package com.aponte.APonte.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String usuario; // login 
	
	@Size(max = 100, min = 0)
	private String email;
	
	@Size(min = 8, message = "O atributo senha deve ter no mínimo 8 caracteres")
	private String senha;
	
	@Size(max = 100, min = 0)
	private String tipo;
	
	@Size(max = 100, min = 0)
	private String registro;
	
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE )
	@JsonIgnoreProperties ("usuario")
	private List<Postagem> postagens;
	
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public List<Postagem> getPostagem() {
		return postagens;
	}

	public void setPostagem(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	
	
	
}
