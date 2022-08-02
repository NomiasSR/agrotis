package br.com.agrotis.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.agrotis.model.Customer;
import br.com.agrotis.model.CustomerRepository;
import br.com.agrotis.model.CustomerService;
import br.com.agrotis.model.TesteAgrotis;


@Controller
@RequestMapping(path="/")
public class RotasController {
	@Autowired
  CustomerRepository repository;
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/")
  public String index() {
		return "index";
	}
	
	@GetMapping("/cadastro")
  public String cadastro() {
		return "cadastro";
	}
	
	@GetMapping("/edicao/{id}")
  public String edicao() {
		return "edicao";
	}
	
  @GetMapping("/customers/index")
  public String customer(Model model) {  	
  	model.addAttribute("dados", repository.search("", null));
  	model.addAttribute("nome", "saimon");
  	return "/customer/index";
  }
  
  @GetMapping("/books")
  public String listBooks(
    Model model, 
    @RequestParam("page") Optional<Integer> page, 
    @RequestParam("size") Optional<Integer> size) {
      int currentPage = page.orElse(1);
      int pageSize = size.orElse(5);
      Page<TesteAgrotis> bookPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize));
      model.addAttribute("bookPage", bookPage);
      
      System.out.println(bookPage.getTotalPages());

      int totalPages = bookPage.getTotalPages();
      if (totalPages > 0) {
          List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
              .boxed()
              .collect(Collectors.toList());
          model.addAttribute("pageNumbers", pageNumbers);
      }

      return "books";
  }

}