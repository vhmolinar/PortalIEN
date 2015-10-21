/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.rmi.RemoteException;

import org.iftm.poo.boundary.EnderecoDTO;
import org.iftm.poo.boundary.LivroDTO;
import org.iftm.poo.boundary.ServicoFreteDTO;
import org.tempuri.CResultado;
import org.tempuri.CalcPrecoPrazoWSSoap;
import org.tempuri.CalcPrecoPrazoWSSoapProxy;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteProxy;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

/**
 * Design pattern Facade
 * 
 * @author vhmolinar
 */
public class ServicoFreteService {
    
	private String cepOrigem        = "38411104";
	private String codEmpresa       = "";
	private String senhaEmpresa     = "";
	private String maoPropria       = "n";
	private String valorDeclarado   = "0";
	private String avisoRecebimento = "n";	
	
    public ServicoFreteService(){
    }
    
    public ServicoFreteDTO calularFrete(ServicoFreteDTO servicoFrete) throws SQLException, SigepClienteException, RemoteException{
            	
    	AtendeClienteProxy atendeCliente = new AtendeClienteProxy();
    	EnderecoERP endereco = atendeCliente.consultaCEP(servicoFrete.getCepDestino());
    	EnderecoDTO enderecoDestino = new EnderecoDTO(endereco);
    	
    	return new ServicoFreteDTO();
    }
    
    public void calculaPrecoPrazo(ServicoFreteDTO servicoFrete){
    	CalcPrecoPrazoWSSoap calcService = new CalcPrecoPrazoWSSoapProxy();
    	
    	LivroService livroService = new LivroService();
    	LivroDTO livro = new LivroDTO(livroService.pesquisarPorCodigo(servicoFrete.getCodigoProduto()));
    	CResultado resultado = calcService.calcPrecoPrazo(codEmpresa, senhaEmpresa, servicoFrete.getCodigoServico(), servicoFrete.getCepOrigem(), servicoFrete.getCepDestino(), nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, maoPropria, valorDeclarado, avisoRecebimento)
    }
            
}
