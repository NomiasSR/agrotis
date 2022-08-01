package br.com.agrotis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.agrotis.model.Laboratorios;
import br.com.agrotis.model.LaboratoriosRepository;

@RestController
@RequestMapping(path="/laboratorios")
public class LaboratoriosController {
  @Autowired
  private LaboratoriosRepository laboratoriosRepository;

  @GetMapping(path="/")
  public @ResponseBody Iterable<Laboratorios> list() {
    return laboratoriosRepository.findAll();
  }
}