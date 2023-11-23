package br.gmetric.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Usuario2 {
	
	@Field(name="id")
	private Integer id;
	
	@Field(name="login")
	private String login;
	
	@Field(name="type")
	private String tipo;
	
	@Field(name="html_url")
	private String url;
	
	@Field(name="avatar_url")
	private String urlAvatar;
	
}
