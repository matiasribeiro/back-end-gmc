package br.gmetric.model.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class QuantidadeCommitAnoView {
	
	
	private String nomeRepositorio;
	
	private String email;
	
	private String ano;
	
	private int total;
	
	public QuantidadeCommitAnoView() {}

}
