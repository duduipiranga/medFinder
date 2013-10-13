package com.medfinder.bo;

public class EspecialidadeBOProxy implements com.medfinder.bo.EspecialidadeBO {
  private String _endpoint = null;
  private com.medfinder.bo.EspecialidadeBO especialidadeBO = null;
  
  public EspecialidadeBOProxy() {
    _initEspecialidadeBOProxy();
  }
  
  public EspecialidadeBOProxy(String endpoint) {
    _endpoint = endpoint;
    _initEspecialidadeBOProxy();
  }
  
  private void _initEspecialidadeBOProxy() {
    try {
      especialidadeBO = (new com.medfinder.bo.EspecialidadeBOServiceLocator()).getEspecialidadeBO();
      if (especialidadeBO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)especialidadeBO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)especialidadeBO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (especialidadeBO != null)
      ((javax.xml.rpc.Stub)especialidadeBO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.medfinder.bo.EspecialidadeBO getEspecialidadeBO() {
    if (especialidadeBO == null)
      _initEspecialidadeBOProxy();
    return especialidadeBO;
  }
  
  public com.medfinder.to.Especialidade[] listarEspecialidades() throws java.rmi.RemoteException{
    if (especialidadeBO == null)
      _initEspecialidadeBOProxy();
    return especialidadeBO.listarEspecialidades();
  }
  
  public void deletarEspecialidade(int id) throws java.rmi.RemoteException{
    if (especialidadeBO == null)
      _initEspecialidadeBOProxy();
    especialidadeBO.deletarEspecialidade(id);
  }
  
  public com.medfinder.to.Especialidade consultarEspecialidade(int id) throws java.rmi.RemoteException{
    if (especialidadeBO == null)
      _initEspecialidadeBOProxy();
    return especialidadeBO.consultarEspecialidade(id);
  }
  
  public void inserirEspecialidade(com.medfinder.to.Especialidade especialidade) throws java.rmi.RemoteException{
    if (especialidadeBO == null)
      _initEspecialidadeBOProxy();
    especialidadeBO.inserirEspecialidade(especialidade);
  }
  
  
}