package br.gmetric.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.gmetric.security.form.IntegracaoForm;

@RestController
@RequestMapping(value = "/integracao")
@CrossOrigin(origins = "*")
public class IntegracaoPythonController {

	
	
	@GetMapping("")
	public ResponseEntity<?> publicar(@RequestBody IntegracaoForm integracaoForm){
		
		String URI = "http://0.0.0.0:5000/teste";
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(URI, String.class);
		
		return ResponseEntity.ok(result);
		
	}
	
}
