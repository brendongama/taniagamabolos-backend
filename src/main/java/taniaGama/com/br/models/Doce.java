package taniaGama.com.br.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import taniaGama.com.br.enums.DoceCategoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;	
	private Double preco;		
	private DoceCategoria categoria;
}
