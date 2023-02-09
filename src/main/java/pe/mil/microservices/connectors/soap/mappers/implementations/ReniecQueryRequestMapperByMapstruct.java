package pe.mil.microservices.connectors.soap.mappers.implementations;

import org.springframework.stereotype.Component;
import pe.mil.microservices.components.mappers.contracts.ISoapMapperRequest;
import pe.mil.microservices.components.mappers.implementations.SoapMapperRequest;
import pe.mil.microservices.connectors.soap.mappers.contracts.IReniecQueryRequestMapperByMapstruct;
import pe.mil.microservices.connectors.wsdl.reniec.Consultar;
import pe.mil.microservices.dto.requests.SoapQueryRequest;

@Component
public class ReniecQueryRequestMapperByMapstruct
    extends SoapMapperRequest<SoapQueryRequest, Consultar>
    implements ISoapMapperRequest<SoapQueryRequest, Consultar> {

    private final IReniecQueryRequestMapperByMapstruct requestMapperByMapstruct;


    public ReniecQueryRequestMapperByMapstruct(final IReniecQueryRequestMapperByMapstruct requestMapperByMapstruct) {
        this.requestMapperByMapstruct = requestMapperByMapstruct;
    }

    @Override
    public Consultar mapRequestBySource(SoapQueryRequest source) {
        return requestMapperByMapstruct.mapperQueryRequest(source);
    }
}
