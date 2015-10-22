package org.iftm.poo.model.domain;

public enum TipoFrete {
	SEDEX(40010),
	SEDEX_A_COBRAR(40045),
	SEDEX_10(40215),
    SEDEX_HOJE(40290),
    PAC(41106);

	private int codigo;

	TipoFrete(int codigo) {
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
			case SEDEX:
				return "SEDEX";
			case SEDEX_A_COBRAR:
				return "SEDEX A Cobrar";
			case SEDEX_10:
				return "SEDEX 10";
			case SEDEX_HOJE:
				return "SEDEX Hoje";
			case PAC:
				return "PAC";
			default:
				return null;
		}
	}
}
