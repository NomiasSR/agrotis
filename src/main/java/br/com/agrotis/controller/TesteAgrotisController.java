package br.com.agrotis.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import br.com.agrotis.model.TesteAgrotis;
import br.com.agrotis.model.TesteAgrotisRepository;


@RestController
@RequestMapping(path="/teste-agrotis")
public class TesteAgrotisController {
	@Autowired
	private TesteAgrotisRepository testeAgrotisRepository;	

	//cadastro de registro
	@PostMapping(path="/")
	public @ResponseBody String add(@RequestBody Map<String, Object> payload) {
		try
		{
	    TesteAgrotis ta = new TesteAgrotis();
	    ta.setNome(payload.get("nome").toString());
	    ta.setDataInicial(payload.get("dataInicial").toString());
	    ta.setDataFinal(payload.get("dataFinal").toString());
	    ta.setPropriedadeId((int) payload.get("propriedadeId"));
	    ta.setLaboratorioId((int)payload.get("laboratorioId"));
	    ta.setObservacoes(payload.get("observacoes").toString());
	    ta.setUsuarioCadastro(9999);
	    testeAgrotisRepository.save(ta);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}		
		return "{\"mensagem\": \"registro salvo com sucesso\", \"status\": 200 }";
  }	
	
	//listagem de registros
  @GetMapping(path="/")
  public @ResponseBody Iterable<TesteAgrotis> list() {
    return testeAgrotisRepository.findAll();
  }
  
	//listagem de registro para edicao
  @GetMapping(path="/{id}")
  public @ResponseBody Optional<TesteAgrotis> edicao(@PathVariable("id") int id) {
    return testeAgrotisRepository.findById(id);
  }  
  
  //exclusao de registro
  @DeleteMapping(path="/{id}")
  public @ResponseBody String delete(@PathVariable("id") int id) {
  	String retorno = "registro deletado com sucesso";
		try
		{			
			if (!testeAgrotisRepository.findById(id).isEmpty()) 
				testeAgrotisRepository.deleteById(id);
			else
				retorno = "registro n??o encontrado";
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}		
		return "{\"mensagem\": \""+retorno+"\", \"status\": 200 }";
  }  
  
  //atualizacao de registro
  @PutMapping(path="/")
	public @ResponseBody String update(@RequestBody Map<String, Object> payload) {
		try
		{
			if (!testeAgrotisRepository.findById((int) payload.get("id")).isEmpty()) 
			{
		    TesteAgrotis ta = new TesteAgrotis();
		    ta.setId((int) payload.get("id"));
		    ta.setNome(payload.get("nome").toString());
		    ta.setDataInicial(payload.get("dataInicial").toString());
		    ta.setDataFinal(payload.get("dataFinal").toString());
		    ta.setPropriedadeId((int) payload.get("propriedadeId"));
		    ta.setLaboratorioId((int)payload.get("laboratorioId"));
		    ta.setObservacoes(payload.get("observacoes").toString());
		    ta.setUsuarioCadastro(9999);
		    testeAgrotisRepository.save(ta);
			}
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
		}		
		return "{\"mensagem\": \"registro atualizado com sucesso\", \"status\": 200 }";
  }
}