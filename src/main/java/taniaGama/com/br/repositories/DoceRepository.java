package taniaGama.com.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import taniaGama.com.br.models.Doce;

@Repository
public interface DoceRepository extends JpaRepository<Doce, Integer>{

}
