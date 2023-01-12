package pe.mil.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.mil.microservices.utils.base.MicroserviceApplication;
import pe.mil.microservices.utils.components.properties.MicroserviceProperties;

import javax.validation.constraints.NotNull;


@SpringBootApplication
public class Application extends MicroserviceApplication {

    public Application(@NotNull final MicroserviceProperties properties) {
        super(properties);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
