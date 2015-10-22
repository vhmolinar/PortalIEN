package org.iftm.poo.boundary;

import org.iftm.poo.model.domain.TipoFrete;

public class TipoFreteDTO {
	
	private String  nome;
	private Integer codigo;
	
	public TipoFreteDTO() {
	
	}
	
	public TipoFreteDTO(TipoFrete tipoFrete){
		this.nome   = tipoFrete.getNome();
		this.codigo = tipoFrete.getCodigo();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
