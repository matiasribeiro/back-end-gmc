package br.gmetric.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.gmetric.model.view.IssueMes;
import br.gmetric.model.view.IssueView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MapaIssueMes {
	
	private String nomeRepositorio;
	
	private Long quantidade;
	
	
	
	public List<Object> construirObjetoView(Map<Object, Map<String, Long>> mapa) {
		
		Map<IssueMes, List<IssueView>> mapas = new HashMap<>();
		List<Object> listaObjetosIssueView = new ArrayList<Object>();
		
		for (Entry<Object, Map<String, Long>> issue : mapa.entrySet()) {
			
//			IssueMes issueMes = new IssueMes();
//			
//			List<Object> lista = new ArrayList<Object>();
//			
			//issueMes.setMes(issue.getKey()); // chave
			listaObjetosIssueView.add(construirObjetoIssue(issue.getKey(), issue.getValue()));
			
		}
		
		return listaObjetosIssueView;
		
	}
	
	
	
	public List<IssueView> construirObjetoIssue(Object obj, Map<String, Long> mapa) {
	
		List<IssueView> listaView = new ArrayList<IssueView>();
		for (Entry<String, Long> e : mapa.entrySet()) {
			
			IssueView iView = new IssueView();
			iView.setMesFechamento(Integer.parseInt(obj.toString()));
			iView.setNomeRepositorio(e.getKey());
			iView.setQuantidade(e.getValue());
			listaView.add(iView);
		}
		return listaView;
	}
	


}
