package com.medfinder.bo;

public class OperadoraBOProxy implements com.medfinder.bo.OperadoraBO {
  private String _endpoint = null;
  private com.medfinder.bo.OperadoraBO operadoraBO = null;
  
  public OperadoraBOProxy() {
    _initOperadoraBOProxy();
  }
  
  public OperadoraBOProxy(String endpoint) {
    _endpoint = endpoint;
    _initOperadoraBOProxy();
  }
  
  private void _initOperadoraBOProxy() {
    try {
      operadoraBO = (new com.medfinder.bo.OperadoraBOServiceLocator()).getOperadoraBO();
      if (operadoraBO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)operadoraBO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)operadoraBO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (operadoraBO != null)
      ((javax.xml.rpc.Stub)operadoraBO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.medfinder.bo.OperadoraBO getOperadoraBO() {
    if (operadoraBO == null)
      _initOperadoraBOProxy();
    return operadoraBO;
  }
  
  public com.medfinder.to.Operadora consultarOperadora(int id) throws java.rmi.RemoteException{
    if (operadoraBO == null)
      _initOperadoraBOProxy();
    return operadoraBO.consultarOperadora(id);
  }
  
  public void deletarOperadora(int id) throws java.rmi.RemoteException{
    if (operadoraBO == null)
      _initOperadoraBOProxy();
    operadoraBO.deletarOperadora(id);
  }
  
  public com.medfinder.to.Operadora[] listarOperadoras() throws java.rmi.RemoteException{
    if (operadoraBO == null)
      _initOperadoraBOProxy();
    return operadoraBO.listarOperadoras();
  }
  
  public void inserirOperadora(com.medfinder.to.Operadora operadora) throws java.rmi.RemoteException{
    if (operadoraBO == null)
      _initOperadoraBOProxy();
    operadoraBO.inserirOperadora(operadora);
  }
  
  
}