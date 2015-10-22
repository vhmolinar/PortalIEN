package org.iftm.poo.controller;

import java.util.Arrays;
import java.util.List;

import org.iftm.poo.model.domain.Embalagem;


public class EmbalagemController {

	public EmbalagemController() {
	}
	
    public List<Embalagem> buscarTodos() throws Exception{
        return Arrays.asList(Embalagem.values());
    }
    
    public Embalagem buscarPorTipo(String tipo) throws Exception {
        return Embalagem.valueOf(tipo);
    }
    
    public Embalagem buscarPorNome(String nome) throws Exception {    	
    	return Arrays.asList(Embalagem.values()).stream().filter(u -> u.getNome().toUpperCase() == nome.toUpperCase()).findFirst().get();
    }
    
    public Embalagem buscarPorCodigo(Integer codigo) throws Exception{
        return Arrays.asList(Embalagem.values()).stream().filter(u -> u.getCodigo() == codigo).findFirst().get();
    }

}
