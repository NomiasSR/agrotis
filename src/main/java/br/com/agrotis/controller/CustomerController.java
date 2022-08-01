package br.com.agrotis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.agrotis.model.Customer;
import br.com.agrotis.model.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping("/search")
    public Page<Customer> search(@RequestParam("searchTerm") String searchTerm,
    		@RequestParam(value = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        return service.search(searchTerm, page, size);
    }

    @GetMapping
    public Page<Customer> getAll() {
        return service.findAll();
    }

}
