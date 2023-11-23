package br.gmetric.model.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TempoDeIssueView {
	
	private int ano;
	private int mes;
	private int dia;
	
	private long hora;
	private long minuto;
	private long segundo;

}
