package br.com.agrotis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Propriedades {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String cnpj;
	private int usuarioCadastro;  
	private String dataCadastro;  
	private int usuarioAlteracao;  
	private String dataAlteracao;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public int getUsuarioCadastro() {
		return usuarioCadastro;
	}
	
	public void setUsuarioCadastro(int usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public int getUsuarioAlteracao() {
		return usuarioAlteracao;
	}
	
	public void setUsuarioAlteracao(int usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}
	
	public String getDataAlteracao() {
		return dataAlteracao;
	}
	
	public void setDataAlteracao(String dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
}