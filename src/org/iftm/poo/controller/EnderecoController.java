/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import org.iftm.poo.boundary.EnderecoDTO;
import org.iftm.poo.negocio.EnderecoService;

import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

/**
 *
 * @author vhmolinar
 */
public class EnderecoController {
    
    private final EnderecoService enderecoService;
    
    public EnderecoController(){
    	enderecoService = new EnderecoService();
    }
    
    public EnderecoDTO buscarEndereco(String cep) throws Exception{
    	EnderecoERP endereco = enderecoService.buscarEndereco(cep);
    	EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
    	return enderecoDTO;
    }
}
