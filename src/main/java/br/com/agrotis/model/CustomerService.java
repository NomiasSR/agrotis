package br.com.agrotis.model;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;
    
    
    public Page<TesteAgrotis> search(String searchTerm, int page, int size) {
    	PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
    	return repository.search(searchTerm.toLowerCase(), pageRequest);
    }
    
    
    public Page<TesteAgrotis> findAll() {
      int page = 0;
      int size = 10;
      PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
      return new PageImpl<>(repository.findAll(), pageRequest, size);
    }
    
    
    public Page<TesteAgrotis> findPaginated(Pageable pageable) {
    List<TesteAgrotis> books = repository.findAll();
      int pageSize = pageable.getPageSize();
      int currentPage = pageable.getPageNumber();
      int startItem = currentPage * pageSize;
      List<TesteAgrotis> list;

      if (books.size() < startItem) {
      	list = Collections.emptyList();
      } else {
        int toIndex = Math.min(startItem + pageSize, books.size());
        list = books.subList(startItem, toIndex);
      }
      Page<TesteAgrotis> bookPage = new PageImpl<TesteAgrotis>(list, PageRequest.of(currentPage, pageSize), books.size());
      return bookPage;
    }

}