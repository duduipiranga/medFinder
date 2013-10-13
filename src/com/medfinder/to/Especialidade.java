/**
 * Especialidade.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.medfinder.to;

public class Especialidade  implements java.io.Serializable {
    private java.lang.String ds_especialidade;

    private int id_especialidade;

    private java.lang.String nm_especialidade;

    public Especialidade() {
    }

    public Especialidade(
           java.lang.String ds_especialidade,
           int id_especialidade,
           java.lang.String nm_especialidade) {
           this.ds_especialidade = ds_especialidade;
           this.id_especialidade = id_especialidade;
           this.nm_especialidade = nm_especialidade;
    }


    /**
     * Gets the ds_especialidade value for this Especialidade.
     * 
     * @return ds_especialidade
     */
    public java.lang.String getDs_especialidade() {
        return ds_especialidade;
    }


    /**
     * Sets the ds_especialidade value for this Especialidade.
     * 
     * @param ds_especialidade
     */
    public void setDs_especialidade(java.lang.String ds_especialidade) {
        this.ds_especialidade = ds_especialidade;
    }


    /**
     * Gets the id_especialidade value for this Especialidade.
     * 
     * @return id_especialidade
     */
    public int getId_especialidade() {
        return id_especialidade;
    }


    /**
     * Sets the id_especialidade value for this Especialidade.
     * 
     * @param id_especialidade
     */
    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }


    /**
     * Gets the nm_especialidade value for this Especialidade.
     * 
     * @return nm_especialidade
     */
    public java.lang.String getNm_especialidade() {
        return nm_especialidade;
    }


    /**
     * Sets the nm_especialidade value for this Especialidade.
     * 
     * @param nm_especialidade
     */
    public void setNm_especialidade(java.lang.String nm_especialidade) {
        this.nm_especialidade = nm_especialidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Especialidade)) return false;
        Especialidade other = (Especialidade) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ds_especialidade==null && other.getDs_especialidade()==null) || 
             (this.ds_especialidade!=null &&
              this.ds_especialidade.equals(other.getDs_especialidade()))) &&
            this.id_especialidade == other.getId_especialidade() &&
            ((this.nm_especialidade==null && other.getNm_especialidade()==null) || 
             (this.nm_especialidade!=null &&
              this.nm_especialidade.equals(other.getNm_especialidade())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDs_especialidade() != null) {
            _hashCode += getDs_especialidade().hashCode();
        }
        _hashCode += getId_especialidade();
        if (getNm_especialidade() != null) {
            _hashCode += getNm_especialidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Especialidade.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://to.medfinder.com", "Especialidade"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds_especialidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.medfinder.com", "ds_especialidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_especialidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.medfinder.com", "id_especialidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nm_especialidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.medfinder.com", "nm_especialidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
