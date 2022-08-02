package br.com.agrotis.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.agrotis.model.Book;
import br.com.agrotis.model.Customer;
import br.com.agrotis.model.CustomerRepository;
import br.com.agrotis.model.CustomerService;

@Service
public class BookService {
	 @Autowired
    private CustomerRepository repository;
	 
    public Page<Customer> findPaginated(Pageable pageable) {
    	final List<Customer> books = repository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Customer> list;

        if (books.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, books.size());
            list = books.subList(startItem, toIndex);
        }

        Page<Customer> bookPage = new PageImpl<Customer>(list, PageRequest.of(currentPage, pageSize), books.size());

        return bookPage;
    }
}


