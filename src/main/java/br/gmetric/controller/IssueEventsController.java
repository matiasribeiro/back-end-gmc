package br.gmetric.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.gmetric.dto.IssueDTO;
import br.gmetric.model.Issue;
import br.gmetric.model.IssueEvents;
import br.gmetric.model.view.IssueDatasContribuinteView;
import br.gmetric.model.view.IssueMes;
import br.gmetric.model.view.IssueQuantidadeUsuario;
import br.gmetric.model.view.IssueView;
import br.gmetric.repository.IIssueEventsRepository;
import br.gmetric.repository.IIssuesRepository;
import br.gmetric.service.IssuesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/issue")
@CrossOrigin(origins = "*")
@Api(value = "Issue")
public class IssueEventsController {

	@Autowired
	private IIssueEventsRepository repositorioIssueEvents;
	
	@Autowired
	private IIssuesRepository repositorioIssues;
	
	@Autowired
	private IssuesService issueService;
	
	@GetMapping("")
	public ResponseEntity<List<IssueEvents>> listarTodos(){
		
		List<IssueEvents> issueEvents = repositorioIssueEvents.findAll();
		
		return ResponseEntity.ok(issueEvents);
		
	}
	
	@ApiOperation(value = "Mostra lista de issues")
	@GetMapping("/todas")
	public ResponseEntity<List<IssueQuantidadeUsuario>> getTodasIssues() throws IOException{
		
		List<IssueQuantidadeUsuario> issue = repositorioIssues.getQuantidadeIssuePorContribuinte();
		
		return ResponseEntity.ok(issue);
		
	}
	
	//@ApiOperation(value = "Mostra lista de issues")
	@GetMapping("/datas")
	public ResponseEntity<List<IssueDatasContribuinteView>> getDatasContribuinte(){
		
		List<IssueDatasContribuinteView> issue = issueService.consultaIssueDatasContribuinte();
		
		return ResponseEntity.ok(issue);
		
	}
	
	
	
	//@ApiOperation(value = "Mostra lista de issues")
	@GetMapping("/quantidade{ano}")
	public ResponseEntity<List<Object>> quantidadeIssuePorMes(@RequestParam(required = true) String ano){
		
		Map<Object, Map<String, Long>> mapa = issueService.consultaQuantMes(ano);
		
		List<Object> result = new ArrayList<Object>();
		
		MapaIssueMes mapaIssueMes = new MapaIssueMes();
		result = mapaIssueMes.construirObjetoView(mapa);
		
		return ResponseEntity.ok(result);
	}
	

	@GetMapping("/lista")
	public ResponseEntity<List<IssueDTO>> tempoDecorrido(){
		
		List<IssueDTO> lista = repositorioIssueEvents.calcularTempoDecorrido();
		
		System.out.println(lista.get(0));
		
		return ResponseEntity.ok(lista);
	}
	
}
