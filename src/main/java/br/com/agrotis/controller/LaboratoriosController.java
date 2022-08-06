package br.com.agrotis.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.agrotis.model.Laboratorios;
import br.com.agrotis.model.LaboratoriosRepository;


@RestController
@RequestMapping(path="/api/laboratorios")
public class LaboratoriosController {
	@Autowired 
	private LaboratoriosRepository laboratoriosRepository;

	@GetMapping(value= {"/list", "/list/{param}"}, produces="application/json")
	public ResponseEntity<List<Laboratorios>> saimon(@PathVariable Optional<String> param) {
		String nome = param.isPresent()? param.get()+"%" : "%";
		return new ResponseEntity<List<Laboratorios>>(laboratoriosRepository.findByNome(nome), HttpStatus.OK);
	}
}






