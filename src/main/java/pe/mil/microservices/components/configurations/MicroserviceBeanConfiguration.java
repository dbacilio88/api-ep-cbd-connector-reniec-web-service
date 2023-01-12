package pe.mil.microservices.components.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pe.mil.microservices.components.connectors.clients.ReniecClientWsdl;
import pe.mil.microservices.constants.WebServiceConstants;

@Configuration
public class MicroserviceBeanConfiguration {

    @Bean
    public Jaxb2Marshaller getReniecJaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(WebServiceConstants.CONTEXT_PATH_RENIEC_GEN_WSDL);
        return marshaller;
    }

    @Bean
    public ReniecClientWsdl getReniecClientWsdl() {
        ReniecClientWsdl client = new ReniecClientWsdl();
        client.setDefaultUri(WebServiceConstants.DEFAULT_URI_RENIEC_WSDL);
        client.setMarshaller(getReniecJaxb2Marshaller());
        client.setUnmarshaller(getReniecJaxb2Marshaller());
        return client;
    }
}
