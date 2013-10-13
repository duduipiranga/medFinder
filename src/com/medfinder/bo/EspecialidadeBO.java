/**
 * EspecialidadeBO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.medfinder.bo;

public interface EspecialidadeBO extends java.rmi.Remote {
    public void inserirEspecialidade(com.medfinder.to.Especialidade especialidade) throws java.rmi.RemoteException;
    public com.medfinder.to.Especialidade consultarEspecialidade(int id) throws java.rmi.RemoteException;
    public com.medfinder.to.Especialidade[] listarEspecialidades() throws java.rmi.RemoteException;
    public void deletarEspecialidade(int id) throws java.rmi.RemoteException;
}
