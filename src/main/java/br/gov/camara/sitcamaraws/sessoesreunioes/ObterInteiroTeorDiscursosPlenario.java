
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
 *         &lt;element name="codSessao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numOrador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numQuarto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numInsercao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "codSessao",
    "numOrador",
    "numQuarto",
    "numInsercao"
})
@XmlRootElement(name = "obterInteiroTeorDiscursosPlenario")
public class ObterInteiroTeorDiscursosPlenario {

    protected String codSessao;
    protected String numOrador;
    protected String numQuarto;
    protected String numInsercao;

    /**
     * Gets the value of the codSessao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSessao() {
        return codSessao;
    }

    /**
     * Sets the value of the codSessao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSessao(String value) {
        this.codSessao = value;
    }

    /**
     * Gets the value of the numOrador property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumOrador() {
        return numOrador;
    }

    /**
     * Sets the value of the numOrador property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumOrador(String value) {
        this.numOrador = value;
    }

    /**
     * Gets the value of the numQuarto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumQuarto() {
        return numQuarto;
    }

    /**
     * Sets the value of the numQuarto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumQuarto(String value) {
        this.numQuarto = value;
    }

    /**
     * Gets the value of the numInsercao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumInsercao() {
        return numInsercao;
    }

    /**
     * Sets the value of the numInsercao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumInsercao(String value) {
        this.numInsercao = value;
    }

}
