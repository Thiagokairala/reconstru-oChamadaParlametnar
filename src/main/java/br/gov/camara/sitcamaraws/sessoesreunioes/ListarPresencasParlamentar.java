
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
 *         &lt;element name="dataIni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numMatriculaParlamentar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "dataIni",
    "dataFim",
    "numMatriculaParlamentar"
})
@XmlRootElement(name = "ListarPresencasParlamentar")
public class ListarPresencasParlamentar {

    protected String dataIni;
    protected String dataFim;
    protected String numMatriculaParlamentar;

    /**
     * Gets the value of the dataIni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataIni() {
        return dataIni;
    }

    /**
     * Sets the value of the dataIni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataIni(String value) {
        this.dataIni = value;
    }

    /**
     * Gets the value of the dataFim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFim() {
        return dataFim;
    }

    /**
     * Sets the value of the dataFim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFim(String value) {
        this.dataFim = value;
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

}
