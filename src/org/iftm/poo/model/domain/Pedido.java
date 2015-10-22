/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.model.domain;

import java.io.Serializable;

public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codigoProduto;
	private String  cepOrigem;
	private String  numeroOrigem;
	private String  cepDestino;
	private String  numeroDestino;
	private Integer codigoEmbalagem;
	private Integer codigoServico;

    public Pedido() {
    	super();
    	this.setCepOrigem("38411104");
    	this.setNumeroOrigem("150");
    }

	public Pedido(Integer codigoProduto, String cepDestino, String numeroDestino, Integer codigoEmbalagem, Integer codigoServico) {
		super();
    	this.setCepOrigem("38411104");
    	this.setNumeroOrigem("150");
		this.codigoProduto   = codigoProduto;
		this.cepDestino      = cepDestino;
		this.numeroDestino   = numeroDestino;
		this.codigoEmbalagem = codigoEmbalagem;
		this.codigoServico   = codigoServico;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	private void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getNumeroOrigem() {
		return numeroOrigem;
	}

	private void setNumeroOrigem(String numeroOrigem) {
		this.numeroOrigem = numeroOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getNumeroDestino() {
		return numeroDestino;
	}

	public void setNumeroDestino(String numeroDestino) {
		this.numeroDestino = numeroDestino;
	}

	public Integer getCodigoEmbalagem() {
		return codigoEmbalagem;
	}

	public void setCodigoEmbalagem(Integer codigoEmbalagem) {
		this.codigoEmbalagem = codigoEmbalagem;
	}

	public Integer getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(Integer codigoServico) {
		this.codigoServico = codigoServico;
	}
}
