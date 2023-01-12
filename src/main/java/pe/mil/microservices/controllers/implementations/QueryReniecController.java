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
import pe.mil.microservices.controllers.contracts.IQueryReniecController;
import pe.mil.microservices.dto.requests.ReniecQueryRequest;
import pe.mil.microservices.services.contracts.IPersonQueryService;
import pe.mil.microservices.utils.components.exceptions.CommonBusinessProcessException;
import pe.mil.microservices.utils.constants.LoggerConstants;
import pe.mil.microservices.utils.dtos.base.BusinessResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static pe.mil.microservices.constants.ProcessConstants.*;

@Log4j2
@RestController
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class QueryReniecController implements IQueryReniecController {

    private final IPersonQueryService queryService;
    private final BusinessResponse businessResponse;
    private final String queryReniecControllerId;

    public QueryReniecController(
        IPersonQueryService queryService,
        BusinessResponse businessResponse
    ) {
        this.queryService = queryService;
        this.businessResponse = businessResponse;
        this.queryReniecControllerId = UUID.randomUUID().toString();
        log.debug("queryReniecControllerId {}", queryReniecControllerId);
        log.debug("QueryReniecController loaded successfully");
    }


    @Override
    @PostMapping(path = QUERY_RENIEC_PERSON, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Object>> query(Mono<ReniecQueryRequest> request) {

        log.debug("method query initialized successfully");
        log.debug("queryReniecControllerId {}", queryReniecControllerId);

        ThreadContext.put(LoggerConstants.CONSTANTS_LOG_METHOD, QUERY_RENIEC_PERSON_LOG_METHOD);

        return this.queryService.query(request)
            .flatMap(processResponse -> {
                log.info("processResponse {}", processResponse);
                if (processResponse.isErrorProcessResponse() || processResponse.isEmptySuccessfullyResponse()) {
                    return Mono.just(businessResponse
                        .getResponse(processResponse.getResponseCode().getResponseCodeValue()));
                }

                return Mono.just(businessResponse
                    .getResponse(processResponse.getBusinessResponse(),
                        processResponse.getResponseCode().getResponseCodeValue()));
            })
            .onErrorResume(WebExchangeBindException.class, Mono::error)
            .onErrorResume(CommonBusinessProcessException.class, e -> Mono
                .just(
                    businessResponse
                        .getResponse(e.getResponseCode().getResponseCodeValue())))
            .doOnError(throwable ->
                log.error("exception error in process query reniec, error: {}", throwable.getMessage())
            ).log();

    }
}
