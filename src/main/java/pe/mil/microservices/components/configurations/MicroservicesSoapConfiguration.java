package pe.mil.microservices.components.configurations;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import pe.mil.microservices.components.wsdl.SoapConfiguration;

@Log4j2
@Data
@Configuration
@ConfigurationProperties(prefix = "soap-integration-services")
public class MicroservicesSoapConfiguration {

    private SoapConfiguration reniecSoapService;
}
