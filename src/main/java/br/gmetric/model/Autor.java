package br.gmetric.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Autor {
	
	@Field(name="name")
	private String nome;
	
	@Field(name="email")
	private String email;
	
	@Field(name="date")
	private String data;
	
	

}
