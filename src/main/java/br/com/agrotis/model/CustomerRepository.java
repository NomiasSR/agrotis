package br.com.agrotis.model;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<TesteAgrotis, Long> {
	
    @Query("FROM TesteAgrotis ta WHERE LOWER(ta.nome) like %:searchTerm% ORDER BY ta.id")    
    Page<Customer> search(@Param("searchTerm") String searchTerm, Pageable pageable);    
    
    @Query("FROM TesteAgrotis ta ORDER BY ta.id")    
    Page<Customer> tudo(Pageable pageable);
}
