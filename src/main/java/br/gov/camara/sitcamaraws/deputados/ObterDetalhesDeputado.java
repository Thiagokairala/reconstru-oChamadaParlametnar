
package br.gov.camara.sitcamaraws.deputados;

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
 *         &lt;element name="ideCadastro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numLegislatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ideCadastro",
    "numLegislatura"
})
@XmlRootElement(name = "ObterDetalhesDeputado")
public class ObterDetalhesDeputado {

    protected String ideCadastro;
    protected String numLegislatura;

    /**
     * Gets the value of the ideCadastro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdeCadastro() {
        return ideCadastro;
    }

    /**
     * Sets the value of the ideCadastro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdeCadastro(String value) {
        this.ideCadastro = value;
    }

    /**
     * Gets the value of the numLegislatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumLegislatura() {
        return numLegislatura;
    }

    /**
     * Sets the value of the numLegislatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumLegislatura(String value) {
        this.numLegislatura = value;
    }

}
