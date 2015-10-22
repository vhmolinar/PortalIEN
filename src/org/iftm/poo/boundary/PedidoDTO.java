package org.iftm.poo.boundary;

import org.iftm.poo.model.domain.Pedido;

public class PedidoDTO {

	private Integer codigoProduto;
	private String  cepOrigem;
	private String  numeroOrigem;
	private String  cepDestino;
	private String  numeroDestino;
	private Integer codigoEmbalagem;
	private Integer codigoServico;

    public PedidoDTO() {
    	super();
    	this.setCepOrigem("38411104");
    	this.setNumeroOrigem("150");
    }

	public PedidoDTO(Pedido pedido) {
		super();
		this.setCodigoProduto(pedido.getCodigoProduto());
		this.setCepOrigem(pedido.getCepOrigem());
		this.setNumeroOrigem(pedido.getNumeroOrigem());
		this.setCepDestino(pedido.getCepDestino());
		this.setNumeroDestino(pedido.getNumeroDestino());
		this.setCodigoEmbalagem(pedido.getCodigoEmbalagem());
		this.setCodigoServico(pedido.getCodigoServico());
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