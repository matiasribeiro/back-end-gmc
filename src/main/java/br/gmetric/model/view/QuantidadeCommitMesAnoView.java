package br.gmetric.model.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class QuantidadeCommitMesAnoView {
	
	
	private String nomeRepositorio;
	
	private String email;
	
	private String mesAno;
	
	private int total;
	
	public QuantidadeCommitMesAnoView() {}

}
