/**
 * OperadoraBO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.medfinder.bo;

public interface OperadoraBO extends java.rmi.Remote {
    public com.medfinder.to.Operadora consultarOperadora(int id) throws java.rmi.RemoteException;
    public void deletarOperadora(int id) throws java.rmi.RemoteException;
    public com.medfinder.to.Operadora[] listarOperadoras() throws java.rmi.RemoteException;
    public void inserirOperadora(com.medfinder.to.Operadora operadora) throws java.rmi.RemoteException;
}
