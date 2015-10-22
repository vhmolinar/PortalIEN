package org.iftm.poo.controller;

import java.util.Arrays;
import java.util.List;

import org.iftm.poo.model.domain.TipoFrete;


public class TipoFreteController {

	public TipoFreteController() {
	}
	
    public List<TipoFrete> buscarTodos() throws Exception{
        return Arrays.asList(TipoFrete.values());
    }
    
    public TipoFrete buscarPorTipo(String tipo) throws Exception {
        return TipoFrete.valueOf(tipo);
    }
    
    public TipoFrete buscarPorNome(String nome) throws Exception {    	
    	return Arrays.asList(TipoFrete.values()).stream().filter(u -> u.getNome().toUpperCase() == nome.toUpperCase()).findFirst().get();
    }
    
    public TipoFrete buscarPorCodigo(Integer codigo) throws Exception{
        return Arrays.asList(TipoFrete.values()).stream().filter(u -> u.getCodigo() == codigo).findFirst().get();
    }

}
