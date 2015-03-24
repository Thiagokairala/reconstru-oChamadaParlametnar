/**
 * ListarDiscursosSessoesCongressoEncerradas.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.camara.www.SitCamaraWS.SessoesReunioes;

public class ListarDiscursosSessoesCongressoEncerradas  implements java.io.Serializable {
    private java.lang.String dataini;

    private java.lang.String datafim;

    public ListarDiscursosSessoesCongressoEncerradas() {
    }

    public ListarDiscursosSessoesCongressoEncerradas(
           java.lang.String dataini,
           java.lang.String datafim) {
           this.dataini = dataini;
           this.datafim = datafim;
    }


    /**
     * Gets the dataini value for this ListarDiscursosSessoesCongressoEncerradas.
     * 
     * @return dataini
     */
    public java.lang.String getDataini() {
        return dataini;
    }


    /**
     * Sets the dataini value for this ListarDiscursosSessoesCongressoEncerradas.
     * 
     * @param dataini
     */
    public void setDataini(java.lang.String dataini) {
        this.dataini = dataini;
    }


    /**
     * Gets the datafim value for this ListarDiscursosSessoesCongressoEncerradas.
     * 
     * @return datafim
     */
    public java.lang.String getDatafim() {
        return datafim;
    }


    /**
     * Sets the datafim value for this ListarDiscursosSessoesCongressoEncerradas.
     * 
     * @param datafim
     */
    public void setDatafim(java.lang.String datafim) {
        this.datafim = datafim;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListarDiscursosSessoesCongressoEncerradas)) return false;
        ListarDiscursosSessoesCongressoEncerradas other = (ListarDiscursosSessoesCongressoEncerradas) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dataini==null && other.getDataini()==null) || 
             (this.dataini!=null &&
              this.dataini.equals(other.getDataini()))) &&
            ((this.datafim==null && other.getDatafim()==null) || 
             (this.datafim!=null &&
              this.datafim.equals(other.getDatafim())));
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
        if (getDataini() != null) {
            _hashCode += getDataini().hashCode();
        }
        if (getDatafim() != null) {
            _hashCode += getDatafim().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListarDiscursosSessoesCongressoEncerradas.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.camara.gov.br/SitCamaraWS/SessoesReunioes", ">listarDiscursosSessoesCongressoEncerradas"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataini");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.camara.gov.br/SitCamaraWS/SessoesReunioes", "dataini"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datafim");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.camara.gov.br/SitCamaraWS/SessoesReunioes", "datafim"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
