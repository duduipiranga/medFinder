/**
 * Operadora.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.medfinder.to;

public class Operadora  implements java.io.Serializable {
    private java.lang.String ds_operadora;

    private int id_operadora;

    public Operadora() {
    }

    public Operadora(
           java.lang.String ds_operadora,
           int id_operadora) {
           this.ds_operadora = ds_operadora;
           this.id_operadora = id_operadora;
    }


    /**
     * Gets the ds_operadora value for this Operadora.
     * 
     * @return ds_operadora
     */
    public java.lang.String getDs_operadora() {
        return ds_operadora;
    }


    /**
     * Sets the ds_operadora value for this Operadora.
     * 
     * @param ds_operadora
     */
    public void setDs_operadora(java.lang.String ds_operadora) {
        this.ds_operadora = ds_operadora;
    }


    /**
     * Gets the id_operadora value for this Operadora.
     * 
     * @return id_operadora
     */
    public int getId_operadora() {
        return id_operadora;
    }


    /**
     * Sets the id_operadora value for this Operadora.
     * 
     * @param id_operadora
     */
    public void setId_operadora(int id_operadora) {
        this.id_operadora = id_operadora;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Operadora)) return false;
        Operadora other = (Operadora) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ds_operadora==null && other.getDs_operadora()==null) || 
             (this.ds_operadora!=null &&
              this.ds_operadora.equals(other.getDs_operadora()))) &&
            this.id_operadora == other.getId_operadora();
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
        if (getDs_operadora() != null) {
            _hashCode += getDs_operadora().hashCode();
        }
        _hashCode += getId_operadora();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Operadora.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://to.medfinder.com", "Operadora"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ds_operadora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.medfinder.com", "ds_operadora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_operadora");
        elemField.setXmlName(new javax.xml.namespace.QName("http://to.medfinder.com", "id_operadora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
