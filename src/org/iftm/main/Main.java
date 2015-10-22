package org.iftm.main;

import org.iftm.poo.controller.TipoFreteController;
import org.iftm.poo.model.domain.TipoFrete;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		TipoFreteController ctr = new TipoFreteController();
		// TipoFrete t = ctr.buscarPorCodigo(40045);
		// TipoFrete t = ctr.buscarPorTipo("SEDEX_A_COBRAR");
		TipoFrete t = ctr.buscarPorNome("SEDEX HOJE");
		System.out.println(t.toString());

	}

}
