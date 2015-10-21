package org.iftm.poo.boundary;

import java.io.Serializable;

import org.iftm.poo.model.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nome;
	private String edicao;
	private Integer ano;
	private Integer qtde;
	
	private Integer codAutor;
	private String nomeAutor;

	private Integer codCategoria;
	private String nomeCategoria;
	
	private String nomeImagem;
	private Double altura;
	private Double largura;
	private Double comprimento;
	private Double diametro;
	private Double peso;
	
	public LivroDTO(){
		
	}
	
	public LivroDTO(Integer codigo, String nome, String edicao, Integer ano, Integer qtde, Integer codAutor, Integer codCategoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.edicao = edicao;
		this.ano = ano;
		this.qtde = qtde;
		this.codAutor = codAutor;
		this.codCategoria = codCategoria;
	}
	
	public LivroDTO(String nome, String edicao, Integer ano, Integer qtde, Integer codAutor, Integer codCategoria) {
		super();
		this.nome = nome;
		this.edicao = edicao;
		this.ano = ano;
		this.qtde = qtde;
		this.codAutor = codAutor;
		this.codCategoria = codCategoria;
	}	


	public LivroDTO(Livro livro){
		this.codigo = livro.getCodLivro();
		this.nome = livro.getNome();
		this.edicao = livro.getEdicao();
		this.ano = livro.getAno();
		this.qtde = 1;
		
		this.codAutor = livro.getAutor() != null ?  livro.getAutor().getCodAutor() : null;
		this.nomeAutor = livro.getAutor() != null ?  livro.getAutor().getNome() : null;
		
		this.codCategoria = livro.getCategoria() != null ? livro.getCategoria().getCodCategoria() : null;
		this.nomeCategoria = livro.getCategoria() != null ? livro.getCategoria().getDescricao() : null;
	}	
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Integer getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(Integer codAutor) {
		this.codAutor = codAutor;
	}

	public Integer getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(Integer codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Double getDiametro() {
		return diametro;
	}

	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
