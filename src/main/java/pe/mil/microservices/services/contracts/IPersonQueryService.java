package pe.mil.microservices.services.contracts;

import pe.mil.microservices.dto.requests.ReniecQueryRequest;
import pe.mil.microservices.services.IGetReniecEntity;
import pe.mil.microservices.utils.dtos.process.BusinessProcessResponse;
import reactor.core.publisher.Mono;

public interface IPersonQueryService
    extends
    IGetReniecEntity<Mono<BusinessProcessResponse>, Mono<ReniecQueryRequest>> {
}
