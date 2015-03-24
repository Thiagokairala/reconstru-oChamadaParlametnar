
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
 *         &lt;element name="idBloco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "idBloco",
    "numLegislatura"
})
@XmlRootElement(name = "ObterPartidosBlocoCD")
public class ObterPartidosBlocoCD {

    protected String idBloco;
    protected String numLegislatura;

    /**
     * Gets the value of the idBloco property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdBloco() {
        return idBloco;
    }

    /**
     * Sets the value of the idBloco property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdBloco(String value) {
        this.idBloco = value;
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
