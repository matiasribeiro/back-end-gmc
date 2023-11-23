package br.gmetric.model.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class QuantidadeCommitMesView {
	

	private String nomeRepositorio;
	
	private String email;
	
	private String mes;
	
	private int total;
	
	public QuantidadeCommitMesView() {}

	
	
	
}
