package org.iftm.poo.boundary;

import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

public class EnderecoDTO {
	
	private String logradouro;
	private String complemento;
	private String complemento2;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String mensagemErro;
	
	public EnderecoDTO(){
	}
	
	public EnderecoDTO(String mensagemErro){
		this.setMensagemErro(mensagemErro);
	}
	
	public EnderecoDTO(EnderecoERP endereco){
		this.logradouro   = endereco.getEnd();
		this.complemento  = endereco.getComplemento();
		this.complemento2 = endereco.getComplemento2();
		this.bairro       = endereco.getBairro();
		this.cep          = endereco.getCep();
		this.cidade       = endereco.getCidade();
		this.uf           = endereco.getUf();
		this.mensagemErro = endereco.getMsgErro();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComplemento2() {
		return complemento2;
	}

	public void setComplemento2(String complemento2) {
		this.complemento2 = complemento2;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	
}
