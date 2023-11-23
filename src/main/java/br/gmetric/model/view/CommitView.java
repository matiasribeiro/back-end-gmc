package br.gmetric.model.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CommitView {

	private String nomeRepositorio;
	
	private String email;
	
	private String mesAno;
	
	private String mes;
	
	private String ano;
	
}
