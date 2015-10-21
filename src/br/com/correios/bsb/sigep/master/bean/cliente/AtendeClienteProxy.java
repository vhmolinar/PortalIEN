package br.com.correios.bsb.sigep.master.bean.cliente;

public class AtendeClienteProxy implements br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente {
  private String _endpoint = null;
  private br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente atendeCliente = null;
  
  public AtendeClienteProxy() {
    _initAtendeClienteProxy();
  }
  
  public AtendeClienteProxy(String endpoint) {
    _endpoint = endpoint;
    _initAtendeClienteProxy();
  }
  
  private void _initAtendeClienteProxy() {
    try {
      atendeCliente = (new br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteServiceLocator()).getAtendeClientePort();
      if (atendeCliente != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)atendeCliente)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)atendeCliente)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (atendeCliente != null)
      ((javax.xml.rpc.Stub)atendeCliente)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente getAtendeCliente() {
    if (atendeCliente == null)
      _initAtendeClienteProxy();
    return atendeCliente;
  }
    
  public br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP consultaCEP(java.lang.String cep) throws java.rmi.RemoteException, br.com.correios.bsb.sigep.master.bean.cliente.SQLException, br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException{
    if (atendeCliente == null)
      _initAtendeClienteProxy();
    return atendeCliente.consultaCEP(cep);
  }
  
  
}