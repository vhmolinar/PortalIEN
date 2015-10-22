package org.iftm.poo.model.facade.rs;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.iftm.poo.boundary.FreteDTO;
import org.iftm.poo.model.domain.Pedido;
import org.iftm.poo.negocio.FreteService;

@Path("/frete")
@Produces({
	MediaType.APPLICATION_JSON})
@Consumes({
	MediaType.APPLICATION_JSON})
public class FreteFacade {
	
	@Inject
	private FreteService freteService;	
	
	@GET
	public FreteDTO calculaFrete() throws Exception{
		Pedido pedido = new Pedido();
		pedido.setCodigoProduto(1);
		pedido.setCepDestino("38415120");
		pedido.setNumeroDestino("410");
		pedido.setCodigoEmbalagem(1);
		pedido.setCodigoServico(40010);
		return freteService.calularFrete(pedido);
	}
	
	@POST
	public FreteDTO calculaFrete(Pedido pedido) throws Exception{
		return freteService.calularFrete(pedido);
	}
}
