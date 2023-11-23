package br.gmetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gmetric.model.Status;
import br.gmetric.repository.IStatusRepository;

@RestController
@RequestMapping(value = "/status")
@CrossOrigin(origins = "*")
public class StatusController {
	
	
	@Autowired
	private IStatusRepository repositorioStatus;

	
	@GetMapping
	public ResponseEntity<List<Status>> listarTodos(){
		
		List<Status> status = repositorioStatus.getTodos();
		
		return ResponseEntity.ok(status);
		
	}

}
