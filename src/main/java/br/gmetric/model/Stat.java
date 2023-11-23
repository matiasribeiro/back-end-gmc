package br.gmetric.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Stat {
	
	@Field(name="additions")
	private int adicionados;
	
	@Field(name="deletions")
	private int excluidos;
	
	@Field(name="total")
	private int total;

	
	

}
