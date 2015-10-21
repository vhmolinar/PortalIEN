package org.iftm.poo.boundary;

public class ServicoFreteDTO {

	private Integer codigoServico;
	private String  nomeServico;
	private Integer codigoProduto;
	private String  nomeProduto;
	private String  cepOrigem;
	private String  enderecoOrigem;
	private String  cepDestino;
	private String  enderecoDestino;
	private String  valorServico;
	private String  prazoEntrega;
	private String  menssagemErro;
	
	public ServicoFreteDTO(){
		cepOrigem = "38411104";
	}
	
	public ServicoFreteDTO(EnderecoDTO origem, EnderecoDTO destino){
		cepOrigem = "38411104";
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

	public String getMenssagemErro() {
		return menssagemErro;
	}

	public void setMenssagemErro(String menssagemErro) {
		this.menssagemErro = menssagemErro;
	}
}