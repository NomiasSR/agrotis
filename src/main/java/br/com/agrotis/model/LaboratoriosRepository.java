package br.com.agrotis.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface LaboratoriosRepository extends CrudRepository<Laboratorios, Integer> {
	
	@Query("select l from Laboratorios l where l.nome like ?#{[0]}")
	List<Laboratorios> findByNome(String nome);	
}
