package taniaGama.com.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taniaGama.com.br.models.Bolo;
import taniaGama.com.br.repositories.BoloRepository;

@Service
public class BoloService {

	@Autowired
	private BoloRepository repository;
	
	public Bolo salvar(Bolo bolo) {
		return repository.save(bolo);
	} 

	public List<Bolo> buscarListaBolos() {
		return repository.findAll();
	}

	public Optional<Bolo> buscarBolo(Integer id) {
		Optional<Bolo> bolo = repository.findById(id);
		return bolo;
	}
	
	public List<Bolo> buscarBoloNome(String nomeBolo) {
		List<Bolo> bolo = repository.findByNomeContaining(nomeBolo);
		return bolo;
	}

	public void deleteBolo(Integer id) {
		repository.deleteById(id);		
	}
}
