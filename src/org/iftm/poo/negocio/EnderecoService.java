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
    
    public EnderecoERP buscarEndereco(String cep){
    	EnderecoERP endereco = new EnderecoERP();
		AtendeClienteProxy atendeCliente = new AtendeClienteProxy();
		try {
			endereco = atendeCliente.consultaCEP(cep);
		} catch (SQLException e) {
			endereco.setMsgErro(e.getMessage1());
		} catch (SigepClienteException e) {
			endereco.setMsgErro(e.getFaultString());
		} catch (RemoteException e) {
			endereco.setMsgErro(e.getMessage());
		}

    	return endereco;
    }
            
}
