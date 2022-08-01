package br.com.agrotis.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TesteAgrotisRepository extends CrudRepository<TesteAgrotis, Integer> {
	@Query("select ta from TesteAgrotis ta where ta.nome like ?#{[0]} and ta.propriedades.nome like ?#{[1]}")
	List<TesteAgrotis> findByNome(String nome, String propriedade);
}
