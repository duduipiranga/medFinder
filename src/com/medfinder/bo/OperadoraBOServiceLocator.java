/**
 * OperadoraBOServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.medfinder.bo;

public class OperadoraBOServiceLocator extends org.apache.axis.client.Service implements com.medfinder.bo.OperadoraBOService {

    public OperadoraBOServiceLocator() {
    }


    public OperadoraBOServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OperadoraBOServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for OperadoraBO
    private java.lang.String OperadoraBO_address = "http://localhost:8080/medFinderProvider/services/OperadoraBO";

    public java.lang.String getOperadoraBOAddress() {
        return OperadoraBO_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String OperadoraBOWSDDServiceName = "OperadoraBO";

    public java.lang.String getOperadoraBOWSDDServiceName() {
        return OperadoraBOWSDDServiceName;
    }

    public void setOperadoraBOWSDDServiceName(java.lang.String name) {
        OperadoraBOWSDDServiceName = name;
    }

    public com.medfinder.bo.OperadoraBO getOperadoraBO() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(OperadoraBO_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getOperadoraBO(endpoint);
    }

    public com.medfinder.bo.OperadoraBO getOperadoraBO(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.medfinder.bo.OperadoraBOSoapBindingStub _stub = new com.medfinder.bo.OperadoraBOSoapBindingStub(portAddress, this);
            _stub.setPortName(getOperadoraBOWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setOperadoraBOEndpointAddress(java.lang.String address) {
        OperadoraBO_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.medfinder.bo.OperadoraBO.class.isAssignableFrom(serviceEndpointInterface)) {
                com.medfinder.bo.OperadoraBOSoapBindingStub _stub = new com.medfinder.bo.OperadoraBOSoapBindingStub(new java.net.URL(OperadoraBO_address), this);
                _stub.setPortName(getOperadoraBOWSDDServiceName());
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
        if ("OperadoraBO".equals(inputPortName)) {
            return getOperadoraBO();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bo.medfinder.com", "OperadoraBOService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bo.medfinder.com", "OperadoraBO"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("OperadoraBO".equals(portName)) {
            setOperadoraBOEndpointAddress(address);
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
