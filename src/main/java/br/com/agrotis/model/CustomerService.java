package br.com.agrotis.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Page<Customer> search(String searchTerm, int page, int size) {
    	PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
    	return repository.search(searchTerm.toLowerCase(), pageRequest);
    }

    public Page<Customer> findAll() {
      int page = 0;
      int size = 10;
      PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
      return new PageImpl<>(repository.findAll(), pageRequest, size);
    }

}