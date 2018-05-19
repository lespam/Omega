
package webservicecli;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para createTable complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="createTable"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tableStructure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createTable", propOrder = {
    "tableStructure"
})
public class CreateTable {

    protected String tableStructure;

    /**
     * Obtiene el valor de la propiedad tableStructure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableStructure() {
        return tableStructure;
    }

    /**
     * Define el valor de la propiedad tableStructure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableStructure(String value) {
        this.tableStructure = value;
    }

}
