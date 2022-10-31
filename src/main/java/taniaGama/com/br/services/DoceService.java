package taniaGama.com.br.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import taniaGama.com.br.models.Doce;
import taniaGama.com.br.repositories.DoceRepository;

@Service
public class DoceService {

	@Autowired
	private DoceRepository repository;
	
	public Doce salvar(Doce doce) {
		return repository.save(doce);
	}

	public List<Doce> buscarListaDoces() {
		return repository.findAll();
	}

	public Optional<Doce> buscarDoce(Integer id) {
		Optional<Doce> doce = repository.findById(id);
		return doce;
	}

	public void deleteDoce(Integer id) {
		repository.deleteById(id);		
	}
}
