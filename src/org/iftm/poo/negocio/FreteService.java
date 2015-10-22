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
import org.iftm.poo.model.domain.Livro;
import org.iftm.poo.model.domain.Pedido;
import org.tempuri.CResultado;
import org.tempuri.CServico;
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

	private String      codEmpresa;
	private String      senhaEmpresa;
	private String      maoPropria;
	private BigDecimal  valorDeclarado;
	private String      avisoRecebimento;
	
	private final AtendeClienteProxy atendeCliente;
	private final LivroService livroService;
	private final CalcPrecoPrazoWSSoapProxy calcService;
	
    public FreteService() throws SQLException, SigepClienteException, RemoteException{
    	this.codEmpresa       = "";
    	this.senhaEmpresa     = "";
    	this.maoPropria       = "n";
    	this.valorDeclarado   = new BigDecimal(0);
    	this.avisoRecebimento = "n";    	
    	
    	this.atendeCliente    = new AtendeClienteProxy();
    	this.livroService     = new LivroService();
    	this.calcService      = new CalcPrecoPrazoWSSoapProxy();
    }
    
    public FreteDTO calularFrete(Pedido pedido){
    	FreteDTO freteCalculado = null;
    	try {
	    	EnderecoDTO enderecoOrigem;
	    	EnderecoERP enderecoO;
			try {
				enderecoO = atendeCliente.consultaCEP(pedido.getCepOrigem());
		    	enderecoOrigem = new EnderecoDTO(enderecoO);
		    	
			} catch (SQLException e) {
				String msg = "Cep Origem:" + e.getMessage1();
				enderecoOrigem = new EnderecoDTO(msg);
				throw new Exception(msg);
				
			} catch (SigepClienteException e) {
				String msg = "Cep Origem:" + e.getFaultString();
				enderecoOrigem = new EnderecoDTO(msg);
				throw new Exception(msg);
				
			} catch (RemoteException e) {
				String msg = "Cep Origem:" + e.getMessage();
				enderecoOrigem = new EnderecoDTO(msg);
				throw new Exception(msg);
			}
	
	    	EnderecoDTO enderecoDestino;
	    	EnderecoERP enderecoD;
			try {
				enderecoD = atendeCliente.consultaCEP(pedido.getCepDestino());
		    	enderecoDestino = new EnderecoDTO(enderecoD);
		    	
			} catch (SQLException e) {
				String msg = "Cep Destino: " + e.getMessage1();
				enderecoDestino = new EnderecoDTO(msg);
				throw new Exception(msg);
				
			} catch (SigepClienteException e) {
				String msg = "Cep Destino: " + e.getFaultString();
				enderecoDestino = new EnderecoDTO(msg);
				throw new Exception(msg);
				
			} catch (RemoteException e) {
				String msg = "Cep Destino: " + e.getMessage();
				enderecoDestino = new EnderecoDTO(msg);
				throw new Exception(msg);
			}
	
	    	LivroDTO livro;
	    	String peso            = "0";
	    	BigDecimal comprimento = new BigDecimal(0); 
	    	BigDecimal altura      = new BigDecimal(0); 
	    	BigDecimal largura     = new BigDecimal(0);
	    	BigDecimal diametro    = new BigDecimal(0);
	    	Livro l;
			try {
				l = livroService.pesquisarPorCodigo(pedido.getCodigoProduto());
		    	livro       = new LivroDTO(l);
		    	peso        = livro.getPeso()        != null ? livro.getPeso().toString() : peso;
		    	comprimento = livro.getComprimento() != null ? livro.getComprimento()     : comprimento; 
		    	altura      = livro.getAltura()      != null ? livro.getAltura()          : altura; 
		    	largura     = livro.getLargura()     != null ? livro.getLargura()         : largura;
		    	diametro    = livro.getDiametro()    != null ? livro.getDiametro()        : diametro;
			} catch (Exception e) {
				livro = new LivroDTO(e.getMessage());
				throw e;
			}
	
	    	CServico servico;
	    	CResultado resultado;
			try {
				resultado = calcService.calcPrecoPrazo(this.codEmpresa, this.senhaEmpresa, pedido.getCodigoServico().toString(), pedido.getCepOrigem(), pedido.getCepDestino(), peso, pedido.getCodigoEmbalagem(), comprimento, altura, largura, diametro, this.maoPropria, this.valorDeclarado, this.avisoRecebimento);
				servico = resultado.getServicos()[0];
			} catch (RemoteException e) {
				servico = new CServico();
				servico.setMsgErro(e.getMessage());
				throw e;
			}

			freteCalculado = new FreteDTO(pedido, enderecoOrigem, enderecoDestino, livro, servico);
		} catch (Exception e) {
			freteCalculado = new FreteDTO(e.getMessage());
		}

    	return freteCalculado;
    }            
}
