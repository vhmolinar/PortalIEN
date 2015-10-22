/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.controller;

import java.rmi.RemoteException;

import org.iftm.poo.boundary.FreteDTO;
import org.iftm.poo.model.domain.Pedido;
import org.iftm.poo.negocio.FreteService;

import br.com.correios.bsb.sigep.master.bean.cliente.SQLException;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

/**
 *
 * @author vhmolinar
 */
public class FreteController {
    
	private final FreteService freteService;
	
    public FreteController() throws SQLException, SigepClienteException, RemoteException{
    	freteService = new FreteService();
    }

    public FreteDTO calcularFrete(Pedido pedido) throws Exception{
    	return freteService.calularFrete(pedido);
    }
}
