package br.gmetric.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "contributors")
public class Colaboradores implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Field(name="contributions")
	private int quantidadeAlteracaoEnviadas;
	
	@Field(name="login")
	private String loginGitHub;
	
	@Field(name="url")
	private String url;
	
	@Field(name="avatar_url")
	private String urlAvatar;
	
	@Field(name="repo_name")
	private String repositorio;

	
	
}
