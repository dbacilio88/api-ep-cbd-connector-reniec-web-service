package pe.mil.microservices.services.implementations;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pe.mil.microservices.components.factories.contracts.ISoapCustomDefinitionFactory;
import pe.mil.microservices.dtos.request.SoapBusinessRequest;
import pe.mil.microservices.services.abstractions.contracts.ISoapCustomDefinition;
import pe.mil.microservices.services.contracts.IReniecQueryCustomService;
import pe.mil.microservices.services.contracts.ISoapCustomProviderService;
import pe.mil.microservices.utils.dtos.generics.GenericBusinessResponse;
import pe.mil.microservices.utils.dtos.process.BusinessProcessResponse;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class ReniecQueryCustomService implements IReniecQueryCustomService {

    private final ISoapCustomDefinitionFactory soapCustomDefinitionFactory;
    private final ISoapCustomProviderService customProviderService;

    public ReniecQueryCustomService(
        final ISoapCustomDefinitionFactory soapCustomDefinitionFactory,
        final ISoapCustomProviderService customProviderService
    ) {
        this.soapCustomDefinitionFactory = soapCustomDefinitionFactory;
        this.customProviderService = customProviderService;
    }

    @Override
    public Mono<BusinessProcessResponse> doOnExecuteReniecQueryService(SoapBusinessRequest<?, ?> request) {

        final ISoapCustomDefinition definition = this.soapCustomDefinitionFactory.factory(request.getSoapDefinitionId());

        return this.customProviderService.doOnExecuteSoapService(request, definition)

            .flatMap(response -> {
                final GenericBusinessResponse<?> businessResponse = new GenericBusinessResponse<>(response.getSoapBusinessResponse());

                return Mono.just(BusinessProcessResponse.setEntitySuccessfullyResponse(businessResponse));
            })

            .doOnSuccess(success ->
                log.debug("process doOnExecuteReniecQueryService successfully completed, response: {}", success.toString())
            ).doOnError(throwable ->
                log.error("service: exception error in process query reniec, error: {}", throwable.getMessage())
            );
    }
}
