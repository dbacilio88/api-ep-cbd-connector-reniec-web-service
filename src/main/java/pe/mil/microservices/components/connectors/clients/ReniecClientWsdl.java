package pe.mil.microservices.components.connectors.clients;

import lombok.extern.log4j.Log4j2;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pe.mil.microservices.components.connectors.reniec.Consultar;
import pe.mil.microservices.components.connectors.reniec.ConsultarResponse;
import pe.mil.microservices.components.connectors.reniec.PeticionConsulta;
import pe.mil.microservices.utils.components.helpers.ContextCurrentTimeHelper;
import reactor.core.publisher.Mono;

@Log4j2
public class ReniecClientWsdl extends WebServiceGatewaySupport {

    public Mono<ConsultarResponse> getResultQueryReniecPerson(PeticionConsulta request) {

        log.info("request {} ", request.toString());
        long start = System.currentTimeMillis();
        Consultar consultar = new Consultar();
        consultar.setArg0(request);
        log.info("consultar {} ", consultar.toString());
        ConsultarResponse query = (ConsultarResponse) getWebServiceTemplate().marshalSendAndReceive(consultar);
        log.info("query {} ", query.toString());
        return Mono.just(
                (ConsultarResponse) getWebServiceTemplate().marshalSendAndReceive(consultar))
            .doOnSuccess(success -> log.info("client: finish process query web service reniec, success: {} - time {} .ms", success.toString(), ContextCurrentTimeHelper.getTotalTime(start)))
            .doOnError(throwable -> log.error("client: exception error in process query web service reniec, error: {}", throwable.getMessage()))
            .log();
    }
}
