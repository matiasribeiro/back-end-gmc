package br.gmetric.model.view;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.gmetric.model.Issue;
import br.gmetric.model.Usuario2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IssueEventsView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String dataFechamento;
	
	private String nomeRepositorio;

	private String url;

	private Usuario2 usuario;

	private Issue issue;
	
	public IssueEventsView() {}

	public IssueEventsView(Integer id, String dataFechamento, String nomeRepositorio) {
		this.id = id;
		this.dataFechamento = dataFechamento;
		this.nomeRepositorio = nomeRepositorio;
	}

	public IssueEventsView(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	
	

}
