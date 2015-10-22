package org.iftm.poo.boundary;

import org.iftm.poo.model.domain.Embalagem;

public class EmbalagemDTO {
	
	private String  nome;
	private Integer codigo;
	
	public EmbalagemDTO() {
	
	}
	
	public EmbalagemDTO(Embalagem embalagem){
		this.nome   = embalagem.getNome();
		this.codigo = embalagem.getCodigo();
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
