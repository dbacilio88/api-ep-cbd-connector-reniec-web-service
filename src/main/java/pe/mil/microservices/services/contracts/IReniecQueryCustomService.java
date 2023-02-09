package pe.mil.microservices.services.contracts;

import pe.mil.microservices.dtos.request.SoapBusinessRequest;
import pe.mil.microservices.utils.dtos.process.BusinessProcessResponse;
import reactor.core.publisher.Mono;

public interface IReniecQueryCustomService {

    Mono<BusinessProcessResponse> doOnExecuteReniecQueryService(SoapBusinessRequest<?, ?> request);
}
