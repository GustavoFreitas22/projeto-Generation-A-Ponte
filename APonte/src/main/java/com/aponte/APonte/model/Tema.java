package com.aponte.APonte.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.*;

@Entity
@Table(name = "tb_tema")
public class Tema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private boolean saude;
	
	private boolean alimentacao;
	
	private boolean educacao;
	
	@NotNull
	private String descricao;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("tema")
	private List<Postagem>postagem;
	
	public Tema() {
		super();
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getSaude() {
		return saude;
	}

	public void setSaude(boolean saude) {
		this.saude = saude;
	}

	public boolean getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(boolean alimentacao) {
		this.alimentacao = alimentacao;
	}

	public boolean getEducacao() {
		return educacao;
	}

	public void setEducacao(boolean educacao) {
		this.educacao = educacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
