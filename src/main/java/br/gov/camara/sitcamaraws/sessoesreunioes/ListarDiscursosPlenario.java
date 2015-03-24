
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
 *         &lt;element name="codigoSessao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parteNomeParlamentar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "dataIni",
    "dataFim",
    "codigoSessao",
    "parteNomeParlamentar",
    "siglaPartido",
    "siglaUF"
})
@XmlRootElement(name = "ListarDiscursosPlenario")
public class ListarDiscursosPlenario {

    protected String dataIni;
    protected String dataFim;
    protected String codigoSessao;
    protected String parteNomeParlamentar;
    protected String siglaPartido;
    protected String siglaUF;

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
     * Gets the value of the codigoSessao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSessao() {
        return codigoSessao;
    }

    /**
     * Sets the value of the codigoSessao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSessao(String value) {
        this.codigoSessao = value;
    }

    /**
     * Gets the value of the parteNomeParlamentar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParteNomeParlamentar() {
        return parteNomeParlamentar;
    }

    /**
     * Sets the value of the parteNomeParlamentar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParteNomeParlamentar(String value) {
        this.parteNomeParlamentar = value;
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
