package pe.mil.microservices.controllers.implementations;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;
import pe.mil.microservices.components.exceptions.SoapBusinessProcessException;
import pe.mil.microservices.controllers.base.ReactorBaseController;
import pe.mil.microservices.controllers.contracts.IQueryReniecCustomController;
import pe.mil.microservices.dto.requests.SoapQueryRequest;
import pe.mil.microservices.dto.responses.SoapQueryResponse;
import pe.mil.microservices.dtos.request.SoapBusinessRequest;
import pe.mil.microservices.services.contracts.IReniecQueryCustomService;
import pe.mil.microservices.utils.constants.LoggerConstants;
import pe.mil.microservices.utils.dtos.base.BusinessResponse;
import pe.mil.microservices.utils.dtos.process.BusinessProcessResponse;
import reactor.core.publisher.Mono;

import static pe.mil.microservices.constants.ProcessConstants.*;
import static pe.mil.microservices.constants.SoapDefinitionsConstants.RENIEC_STANDARD_DEFINITION;

@Log4j2
@RestController
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class QueryReniecCustomController extends ReactorBaseController implements IQueryReniecCustomController {

    private final IReniecQueryCustomService reniecQueryCustomService;

    public QueryReniecCustomController(
        IReniecQueryCustomService reniecQueryCustomService,
        BusinessResponse businessResponse
    ) {
        super("QueryReniecController", businessResponse);
        this.reniecQueryCustomService = reniecQueryCustomService;

    }

    @Override
    @PostMapping(path = QUERY_RENIEC_PERSON, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Object>> doOnReniecQuery(SoapQueryRequest request) {

        log.debug("method query initialized successfully");
        ThreadContext.put(LoggerConstants.CONSTANTS_LOG_METHOD, QUERY_RENIEC_PERSON_LOG_METHOD);
        final SoapBusinessRequest<SoapQueryRequest, SoapQueryResponse> soapBusinessRequest = new SoapBusinessRequest<>();
        soapBusinessRequest.setSoapDefinitionId(RENIEC_STANDARD_DEFINITION);
        soapBusinessRequest.setSoapBusinessRequest(request);

        return super.getResponseEntity(this.reniecQueryCustomService.doOnExecuteReniecQueryService(soapBusinessRequest)
            .onErrorResume(WebExchangeBindException.class, Mono::error)
            .onErrorResume(SoapBusinessProcessException.class, e -> Mono.just(BusinessProcessResponse
                .setBusinessProcessError(e.getResponseCode())))
            .doOnError(throwable -> log.error("exception error in process getById, error: {}", throwable.getMessage()))
            .doOnError(throwable -> log.error("exception error in process getById, error: {}", throwable.getMessage())), "doOnReniecQuery");
    }
}
