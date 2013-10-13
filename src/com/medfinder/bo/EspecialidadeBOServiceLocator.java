/**
 * EspecialidadeBOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.medfinder.bo;

public class EspecialidadeBOServiceLocator extends org.apache.axis.client.Service implements com.medfinder.bo.EspecialidadeBOService {

    public EspecialidadeBOServiceLocator() {
    }


    public EspecialidadeBOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EspecialidadeBOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EspecialidadeBO
    private java.lang.String EspecialidadeBO_address = "http://localhost:8080/medFinderProvider/services/EspecialidadeBO";

    public java.lang.String getEspecialidadeBOAddress() {
        return EspecialidadeBO_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EspecialidadeBOWSDDServiceName = "EspecialidadeBO";

    public java.lang.String getEspecialidadeBOWSDDServiceName() {
        return EspecialidadeBOWSDDServiceName;
    }

    public void setEspecialidadeBOWSDDServiceName(java.lang.String name) {
        EspecialidadeBOWSDDServiceName = name;
    }

    public com.medfinder.bo.EspecialidadeBO getEspecialidadeBO() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EspecialidadeBO_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEspecialidadeBO(endpoint);
    }

    public com.medfinder.bo.EspecialidadeBO getEspecialidadeBO(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.medfinder.bo.EspecialidadeBOSoapBindingStub _stub = new com.medfinder.bo.EspecialidadeBOSoapBindingStub(portAddress, this);
            _stub.setPortName(getEspecialidadeBOWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEspecialidadeBOEndpointAddress(java.lang.String address) {
        EspecialidadeBO_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.medfinder.bo.EspecialidadeBO.class.isAssignableFrom(serviceEndpointInterface)) {
                com.medfinder.bo.EspecialidadeBOSoapBindingStub _stub = new com.medfinder.bo.EspecialidadeBOSoapBindingStub(new java.net.URL(EspecialidadeBO_address), this);
                _stub.setPortName(getEspecialidadeBOWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EspecialidadeBO".equals(inputPortName)) {
            return getEspecialidadeBO();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bo.medfinder.com", "EspecialidadeBOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bo.medfinder.com", "EspecialidadeBO"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EspecialidadeBO".equals(portName)) {
            setEspecialidadeBOEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
