//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.01.12 a las 11:18:58 AM COT 
//


package pe.mil.microservices.components.connectors.reniec;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://ws.reniec.gob.pe/}peticionConsulta" form="unqualified"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "arg0"
})
@XmlRootElement(name = "consultar", namespace = "http://ws.reniec.gob.pe/")
public class Consultar {

    @XmlElement(required = true, nillable = true, namespace = "http://ws.reniec.gob.pe/")
    protected PeticionConsulta arg0;

    /**
     * Obtiene el valor de la propiedad arg0.
     *
     * @return possible object is
     * {@link PeticionConsulta }
     */
    public PeticionConsulta getArg0() {
        return arg0;
    }

    /**
     * Define el valor de la propiedad arg0.
     *
     * @param value allowed object is
     *              {@link PeticionConsulta }
     */
    public void setArg0(PeticionConsulta value) {
        this.arg0 = value;
    }

    @Override
    public String toString() {
        return "Consultar{" +
            "arg0=" + arg0 +
            '}' ;
    }
}
