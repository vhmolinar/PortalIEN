package org.iftm.poo.model.facade.rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.iftm.poo.boundary.EnderecoDTO;
import org.iftm.poo.negocio.EnderecoService;

import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;

@Path("/endereco")
@Produces({
	MediaType.APPLICATION_JSON})
@Consumes({
	MediaType.APPLICATION_JSON})
public class EnderecoFacade {
	
	@Inject
	private EnderecoService enderecoService;	
	
	@GET
	@Path("{cep}")
	public EnderecoDTO getEndereco(@PathParam("cep") String cep) throws Exception{
		EnderecoERP endereco = enderecoService.buscarEndereco(cep);
		EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);
		return enderecoDTO;		
	}
}
