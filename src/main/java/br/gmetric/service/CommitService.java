package br.gmetric.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gmetric.model.view.CommitView;
import br.gmetric.model.view.QuantidadeCommitAnoView;
import br.gmetric.model.view.QuantidadeCommitMesAnoView;
import br.gmetric.model.view.QuantidadeCommitMesView;
import br.gmetric.model.view.QuantidadeCommitView;
import br.gmetric.repository.impl.RepositorioCommitCustomizadoImpl;

@Service
public class CommitService {

	@Autowired
	private RepositorioCommitCustomizadoImpl repositorioCommitCustomizadoImpl;
	
	
	public List<QuantidadeCommitMesView> getCommitsPorMes() {
		
		List<QuantidadeCommitView> commits = repositorioCommitCustomizadoImpl.getQuantidadeCommitPorMes();
		List<QuantidadeCommitMesView> listaCommitsMes = new ArrayList<QuantidadeCommitMesView>();
		
		for (QuantidadeCommitView c : commits) {
			
			QuantidadeCommitMesView quantCommitMes = new QuantidadeCommitMesView();
			quantCommitMes.setEmail(c.getId().getEmail());
			quantCommitMes.setNomeRepositorio(c.getId().getNomeRepositorio());
			quantCommitMes.setMes(c.getId().getMes());
			quantCommitMes.setTotal(c.getTotal());
			listaCommitsMes.add(quantCommitMes);
		}
		return listaCommitsMes;
	}
	
	public List<QuantidadeCommitAnoView> getCommitsPorAno() {
		
		List<QuantidadeCommitView> commits = repositorioCommitCustomizadoImpl.getQuantidadeCommitPorAno();
		List<QuantidadeCommitAnoView> listaCommitsAno = new ArrayList<QuantidadeCommitAnoView>();
		
		for (QuantidadeCommitView c : commits) {
			
			QuantidadeCommitAnoView quantCommitAno = new QuantidadeCommitAnoView();
			quantCommitAno.setEmail(c.getId().getEmail());
			quantCommitAno.setNomeRepositorio(c.getId().getNomeRepositorio());
			quantCommitAno.setAno(c.getId().getAno());
			quantCommitAno.setTotal(c.getTotal());
			listaCommitsAno.add(quantCommitAno);
		}
		
		listaCommitsAno = listaCommitsAno.stream()
		        .sorted((p1, p2) -> Integer.compare(p2.getTotal(), p1.getTotal()))
		        .collect(Collectors.toList());


		
		return listaCommitsAno;
	}

	public List<QuantidadeCommitMesAnoView> getCommitsPorMesAno() {
		
		List<QuantidadeCommitView> commits = repositorioCommitCustomizadoImpl.getQuantidadeCommitPorMesAno();
		List<QuantidadeCommitMesAnoView> listaCommitsMesAno = new ArrayList<QuantidadeCommitMesAnoView>();
		
		for (QuantidadeCommitView c : commits) {
			
			QuantidadeCommitMesAnoView quantCommitAno = new QuantidadeCommitMesAnoView();
			quantCommitAno.setEmail(c.getId().getEmail());
			quantCommitAno.setNomeRepositorio(c.getId().getNomeRepositorio());
			quantCommitAno.setMesAno(c.getId().getMesAno());
			quantCommitAno.setTotal(c.getTotal());
			listaCommitsMesAno.add(quantCommitAno);
		}
		

		listaCommitsMesAno = listaCommitsMesAno.stream()
		        .sorted((p1, p2) -> Integer.compare(p2.getTotal(), p1.getTotal()))
		        .filter(p -> !p.getNomeRepositorio().equalsIgnoreCase("SeleniumHQ_selenium"))
		        .collect(Collectors.toList());

		
		return listaCommitsMesAno;
	}
	
	public void converterParaMes(String data) {
		
		
//		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM"); 
//		LocalDate localData = LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM")); 
//		
		System.out.println(data.substring(0,4));
		
		
	}
	
	
}
