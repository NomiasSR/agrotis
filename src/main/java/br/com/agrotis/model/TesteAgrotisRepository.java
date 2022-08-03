package br.com.agrotis.model;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TesteAgrotisRepository extends JpaRepository<TesteAgrotis, Integer> {
	@Query("select ta from TesteAgrotis ta where ta.nome like ?#{[0]} and ta.propriedades.nome like ?#{[1]}")
	List<TesteAgrotis> findByNome(String nome, String propriedade);
	
	@Query("FROM TesteAgrotis ta WHERE LOWER(ta.nome) like %:searchTerm% ORDER BY ta.id")    
	    Page<Customer> search(@Param("searchTerm") String searchTerm, Pageable pageable);    
	    
    @Query("FROM TesteAgrotis ta ORDER BY ta.id")    
    Page<Customer> tudo(Pageable pageable);

}