
package br.gov.camara.sitcamaraws.sessoesreunioes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numMatriculaParlamentar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaPartido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaUF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "data",
    "numMatriculaParlamentar",
    "siglaPartido",
    "siglaUF"
})
@XmlRootElement(name = "ListarPresencasDia")
public class ListarPresencasDia {

    protected String data;
    protected String numMatriculaParlamentar;
    protected String siglaPartido;
    protected String siglaUF;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

    /**
     * Gets the value of the numMatriculaParlamentar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumMatriculaParlamentar() {
        return numMatriculaParlamentar;
    }

    /**
     * Sets the value of the numMatriculaParlamentar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumMatriculaParlamentar(String value) {
        this.numMatriculaParlamentar = value;
    }

    /**
     * Gets the value of the siglaPartido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaPartido() {
        return siglaPartido;
    }

    /**
     * Sets the value of the siglaPartido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaPartido(String value) {
        this.siglaPartido = value;
    }

    /**
     * Gets the value of the siglaUF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaUF() {
        return siglaUF;
    }

    /**
     * Sets the value of the siglaUF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaUF(String value) {
        this.siglaUF = value;
    }

}
