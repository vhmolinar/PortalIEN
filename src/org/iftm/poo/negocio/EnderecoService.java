/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.rmi.RemoteException;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteProxy;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

/**
 * Design pattern Facade
 * 
 * @author vhmolinar
 */
public class EnderecoService {
    
    public EnderecoService(){
    }
    
    public EnderecoERP buscarEndereco(String cep) throws SQLException, SigepClienteException, RemoteException{
    	return new AtendeClienteProxy().consultaCEP(cep);
    }
            
}
