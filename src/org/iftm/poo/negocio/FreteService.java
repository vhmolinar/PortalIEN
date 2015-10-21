/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iftm.poo.negocio;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import org.iftm.poo.boundary.EnderecoDTO;
import org.iftm.poo.boundary.FreteDTO;
import org.iftm.poo.boundary.LivroDTO;
import org.tempuri.CResultado;
import org.tempuri.CServico;
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
public class FreteService {
    
	private String     cepOrigem        = "38411104";
	private String     codEmpresa       = "";
	private String     senhaEmpresa     = "";
	private String     maoPropria       = "n";
	private BigDecimal valorDeclarado   = new BigDecimal(0);
	private String     avisoRecebimento = "n";	
	
    public FreteService(){
    }
    
    public FreteDTO calularFrete(FreteDTO servicoFrete) throws SQLException, SigepClienteException, RemoteException{
            	
    	AtendeClienteProxy atendeCliente = new AtendeClienteProxy();
    	EnderecoERP endereco = atendeCliente.consultaCEP(servicoFrete.getCepDestino());
    	EnderecoDTO enderecoDestino = new EnderecoDTO(endereco);
    	
    	return new FreteDTO();
    }
    
    public void calculaPrecoPrazo(FreteDTO servicoFrete) throws Exception{
    	CalcPrecoPrazoWSSoap calcService = new CalcPrecoPrazoWSSoapProxy();
    	
    	LivroService livroService = new LivroService();
    	LivroDTO livro = new LivroDTO(livroService.pesquisarPorCodigo(servicoFrete.getCodigoProduto()));
    	CResultado resultado = calcService.calcPrecoPrazo(codEmpresa, senhaEmpresa, servicoFrete.getCodigoServico().toString(), servicoFrete.getCepOrigem(), servicoFrete.getCepDestino(), livro.getPeso().toString(), servicoFrete.getCodigoFormato(), livro.getComprimento(), livro.getAltura(), livro.getLargura(), livro.getDiametro(), maoPropria, valorDeclarado, avisoRecebimento);
    	CServico servico = resultado.getServicos()[0];
    }
            
}
