package taniaGama.com.br.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import taniaGama.com.br.models.Bolo;

@Repository
public interface BoloRepository extends JpaRepository<Bolo, Integer>{
	List<Bolo> findByNomeContaining(String nomeBolo);
}
