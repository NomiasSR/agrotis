package br.com.agrotis.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class TesteAgrotis {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String dataInicial;  
	private String dataFinal;	
	private String observacoes;
	private int usuarioCadastro;  
	private String dataCadastro;  
	private int usuarioAlteracao;  
	private String dataAlteracao;
	
	@Column(name = "propriedade_id")
	private int propriedadeId;
	
	@Column(name = "laboratorio_id")
	private int laboratorioId;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="propriedade_id", insertable=false, updatable=false)		
  private Propriedades propriedades;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="laboratorio_id", insertable=false, updatable=false)		
  private Laboratorios laboratorios;
	
	public Propriedades getPropriedades() {
		return this.propriedades;
	}
	
	public Laboratorios getLaboratorios() {
		return this.laboratorios;
	}
	
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

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
	
	public Integer getPropriedadeId() {
		return propriedadeId;
	}

	public void setPropriedadeId(Integer propriedadeId) {
		this.propriedadeId = propriedadeId;
	}
	
	public Integer getLaboratorioId() {
		return laboratorioId;
	}

	public void setLaboratorioId(Integer laboratorioId) {
		this.laboratorioId = laboratorioId;
	}
}