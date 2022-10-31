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

import taniaGama.com.br.models.Doce;
import taniaGama.com.br.services.DoceService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/doce")
public class DoceController {

	@Autowired
	private DoceService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Doce> buscarDoce(@PathVariable Integer id){
		Optional<Doce> doce = service.buscarDoce(id);
		return ResponseEntity.ok().body(doce.get()); 
	}
	
	@GetMapping
	public ResponseEntity<List<Doce>> buscarListaDoces(){
		List<Doce> listaDoces = service.buscarListaDoces();
		return ResponseEntity.ok().body(listaDoces);
	}
	
	@PostMapping
	public ResponseEntity<Doce> salvar(@RequestBody Doce doce) {
		return ResponseEntity.ok().body(service.salvar(doce));  
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doce> atualizarDoce(@RequestBody Doce doce, @PathVariable Integer id) {
		Optional<Doce> oldDoce = service.buscarDoce(id);
		if(oldDoce.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		doce.setId(id);
		Doce newDoce = service.salvar(doce);
		return ResponseEntity.status(HttpStatus.CREATED).body(newDoce);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Doce> deletarDoce(@PathVariable Integer id) {	
		Optional<Doce> oldDoce = service.buscarDoce(id);
		if(oldDoce.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		service.deleteDoce(id);
		return ResponseEntity.noContent().build();
	}
	
}
