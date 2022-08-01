package br.com.agrotis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.agrotis.model.Propriedades;
import br.com.agrotis.model.PropriedadesRepository;

@RestController
@RequestMapping(path="/propriedades")
public class PropriedadesController {
  @Autowired
  private PropriedadesRepository propriedadesRepository;

  @GetMapping(path="/")
  public @ResponseBody Iterable<Propriedades> list() {
    return propriedadesRepository.findAll();
  }
}