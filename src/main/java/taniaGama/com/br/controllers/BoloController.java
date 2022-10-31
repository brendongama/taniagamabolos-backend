package taniaGama.com.br.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import taniaGama.com.br.models.Bolo;
import taniaGama.com.br.services.BoloService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/bolo")
public class BoloController {

	@Autowired
	private BoloService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Bolo> buscarBolo(@PathVariable Integer id){
		Optional<Bolo> bolo = service.buscarBolo(id);
		return ResponseEntity.ok().body(bolo.get());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Bolo>> buscarBolo(@PathVariable String nome){
		List<Bolo> bolos = service.buscarBoloNome(nome);
		if(bolos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(bolos);
	}
	
	@GetMapping
	public ResponseEntity<List<Bolo>> buscarListaBolos(){
		List<Bolo> listaBolos = service.buscarListaBolos();
		return ResponseEntity.ok().body(listaBolos);
	}
	
	@PostMapping
	public ResponseEntity<Bolo> salvar(@RequestBody Bolo bolo) {
		return ResponseEntity.ok().body(service.salvar(bolo));  
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Bolo> atualizarBolo(@RequestBody Bolo bolo, @PathVariable Integer id) {
		Optional<Bolo> oldBolo = service.buscarBolo(id);
		if(oldBolo.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		bolo.setId(id);
		Bolo newBolo = service.salvar(bolo);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBolo);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Bolo> deletarBolo(@PathVariable Integer id) {	
		Optional<Bolo> oldBolo = service.buscarBolo(id);
		if(oldBolo.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		service.deleteBolo(id);
		return ResponseEntity.noContent().build();
	}
	
}
