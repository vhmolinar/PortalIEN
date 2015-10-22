package org.iftm.poo.boundary;

import org.iftm.poo.controller.EmbalagemController;
import org.iftm.poo.controller.TipoFreteController;
import org.iftm.poo.model.domain.Pedido;
import org.tempuri.CServico;

public class FreteDTO {

	private Integer codigoServico;
	private String  nomeServico;
	private Integer codigoProduto;
	private String  nomeProduto;
	private String  cepOrigem;
	private String  enderecoOrigem;
	private String  cepDestino;
	private String  enderecoDestino;
	private Integer codigoEmbalagem;
	private String  nomeEmbalagem;
	private String  valorServico;
	private String  prazoEntrega;
	private String  mensagemErro;
	
	public FreteDTO(){
	}
	
	public FreteDTO(Pedido pedido, EnderecoDTO origem, EnderecoDTO destino, LivroDTO livro, CServico servico) throws Exception{
		this.setCepOrigem(origem.getCep());
		this.setEnderecoOrigem("Rua " + origem.getLogradouro() + " " + pedido.getNumeroOrigem() + " - " + origem.getBairro() + " - " + origem.getCidade() + " - " + origem.getUf());
		
		this.setCepDestino(origem.getCep());
		this.setEnderecoDestino("Rua " + destino.getLogradouro() + " " + pedido.getNumeroDestino() + " - " + destino.getBairro() + " - " + destino.getCidade() + " - " + destino.getUf());
		
		this.setCodigoProduto(livro.getCodigo());
		this.setNomeProduto(livro.getNome());

		this.setCodigoEmbalagem(pedido.getCodigoEmbalagem());
		this.setNomeEmbalagem(new EmbalagemController().buscarPorCodigo(pedido.getCodigoEmbalagem()).getNome());
		
		this.setCodigoServico(servico.getCodigo());
		this.setNomeServico(new TipoFreteController().buscarPorCodigo(servico.getCodigo()).getNome());
		
		this.setValorServico(servico.getValor().isEmpty()        ? "" : "R$ " + servico.getValor());
		this.setPrazoEntrega(servico.getPrazoEntrega().isEmpty() ? "" : servico.getPrazoEntrega() + " dia(s)");
		this.setMensagemErro(servico.getMsgErro().isEmpty()     ? "" : servico.getMsgErro());
	}	

	public FreteDTO(String mensagemErro) {
		this.setMensagemErro(mensagemErro);
	}

	public Integer getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(Integer codigoServico) {
		this.codigoServico = codigoServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(String enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}
	
	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(String enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}
	
	public Integer getCodigoEmbalagem() {
		return codigoEmbalagem;
	}

	public void setCodigoEmbalagem(Integer codigoEmbalagem) {
		this.codigoEmbalagem = codigoEmbalagem;
	}

	public String getNomeEmbalagem() {
		return nomeEmbalagem;
	}

	public void setNomeEmbalagem(String nomeEmbalagem) {
		this.nomeEmbalagem = nomeEmbalagem;
	}

	public String getValorServico() {
		return valorServico;
	}

	public void setValorServico(String valorServico) {
		this.valorServico = valorServico;
	}

	public String getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String menssagemErro) {
		this.mensagemErro = menssagemErro;
	}
}