package org.iftm.poo.boundary;

import java.io.Serializable;
import java.math.BigDecimal;

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
	private BigDecimal altura;
	private BigDecimal largura;
	private BigDecimal comprimento;
	private BigDecimal diametro;
	private BigDecimal peso;
	
	private String mensagemErro;
	
	public LivroDTO(){
		
	}
	
	public LivroDTO(String mensagemErro){
		this.setMensagemErro(mensagemErro);
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
		
		this.nomeImagem = livro.getNomImagem() != null ? livro.getNomImagem() : "";
		this.altura = livro.getAltura() != null ? livro.getAltura() : new BigDecimal(0);
		this.largura = livro.getLargura() != null ? livro.getLargura() : new BigDecimal(0);
		this.comprimento = livro.getComprimento() != null ? livro.getComprimento() : new BigDecimal(0);
		this.diametro = livro.getDiametro() != null ? livro.getDiametro() : new BigDecimal(0);
		this.peso = livro.getPeso() != null ? livro.getPeso() : new BigDecimal(0);
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

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getLargura() {
		return largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

	public BigDecimal getComprimento() {
		return comprimento;
	}

	public void setComprimento(BigDecimal comprimento) {
		this.comprimento = comprimento;
	}

	public BigDecimal getDiametro() {
		return diametro;
	}

	public void setDiametro(BigDecimal diametro) {
		this.diametro = diametro;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
}
