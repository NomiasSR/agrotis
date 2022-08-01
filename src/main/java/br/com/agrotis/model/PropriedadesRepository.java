package br.com.agrotis.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PropriedadesRepository extends CrudRepository<Propriedades, Integer> {

	@Query("select p from Propriedades p where p.nome like ?#{[0]}")
	List<Propriedades> findByNome(String nome);	
}
