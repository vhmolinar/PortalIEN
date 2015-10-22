package org.iftm.poo.model.domain;

public enum Embalagem {
	CAIXA_PACOTE(1),
	ROLO_PRISMA(2),
	ENVELOPE(3);

	private int codigo;

	Embalagem(int codigo) {
		this.setCodigo(codigo);
	}
	
	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome(){
		return this.toString();
	}
	
	@Override
	public String toString() {
		switch(this) {
			case CAIXA_PACOTE:
				return "Formato Caixa/Pacote";
			case ROLO_PRISMA:
				return "Formato Rolo/Prisma";
			case ENVELOPE:
				return "Envelope";
			default:
				return null;
		}
	}
}
