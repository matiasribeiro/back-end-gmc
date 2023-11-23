package br.gmetric.model.view;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjetoView implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String nome;
	
	private String visibilidade;

	public ProjetoView(int id, String nome, String visibilidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.visibilidade = visibilidade;
	}
	
	

}
