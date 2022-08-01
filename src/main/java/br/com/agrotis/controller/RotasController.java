package br.com.agrotis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path="/")
public class RotasController {
	
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
}