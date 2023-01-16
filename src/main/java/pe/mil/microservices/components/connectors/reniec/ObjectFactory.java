//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2023.01.13 a las 09:37:30 AM COT 
//


package pe.mil.microservices.components.connectors.reniec;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.mil.microservices.components.connectors.reniec package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.mil.microservices.components.connectors.reniec
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Consultar }
     * 
     */
    public Consultar createConsultar() {
        return new Consultar();
    }

    /**
     * Create an instance of {@link PeticionConsulta }
     * 
     */
    public PeticionConsulta createPeticionConsulta() {
        return new PeticionConsulta();
    }

    /**
     * Create an instance of {@link Actualizarcredencial }
     * 
     */
    public Actualizarcredencial createActualizarcredencial() {
        return new Actualizarcredencial();
    }

    /**
     * Create an instance of {@link PeticionActualizarCredencial }
     * 
     */
    public PeticionActualizarCredencial createPeticionActualizarCredencial() {
        return new PeticionActualizarCredencial();
    }

    /**
     * Create an instance of {@link ConsultarResponse }
     * 
     */
    public ConsultarResponse createConsultarResponse() {
        return new ConsultarResponse();
    }

    /**
     * Create an instance of {@link ResultadoConsulta }
     * 
     */
    public ResultadoConsulta createResultadoConsulta() {
        return new ResultadoConsulta();
    }

    /**
     * Create an instance of {@link ActualizarcredencialResponse }
     * 
     */
    public ActualizarcredencialResponse createActualizarcredencialResponse() {
        return new ActualizarcredencialResponse();
    }

    /**
     * Create an instance of {@link ResultadoActualizacionCredencial }
     * 
     */
    public ResultadoActualizacionCredencial createResultadoActualizacionCredencial() {
        return new ResultadoActualizacionCredencial();
    }

    /**
     * Create an instance of {@link DatosPersona }
     * 
     */
    public DatosPersona createDatosPersona() {
        return new DatosPersona();
    }

}
