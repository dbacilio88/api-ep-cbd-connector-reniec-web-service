package pe.mil.microservices.connectors.soap.mappers.implementations;

import org.springframework.stereotype.Component;
import pe.mil.microservices.components.mappers.contracts.ISoapMapperResponse;
import pe.mil.microservices.components.mappers.implementations.SoapMapperResponse;
import pe.mil.microservices.connectors.soap.mappers.contracts.IReniecQueryRequestMapperByMapstruct;
import pe.mil.microservices.connectors.wsdl.reniec.ConsultarResponse;
import pe.mil.microservices.dto.responses.SoapQueryResponse;

@Component
public class ReniecQueryResponseMapperByMapstruct
    extends SoapMapperResponse<ConsultarResponse, SoapQueryResponse>
    implements ISoapMapperResponse<ConsultarResponse, SoapQueryResponse> {

    private final IReniecQueryRequestMapperByMapstruct requestMapperByMapstruct;

    public ReniecQueryResponseMapperByMapstruct(final IReniecQueryRequestMapperByMapstruct requestMapperByMapstruct) {
        this.requestMapperByMapstruct = requestMapperByMapstruct;
    }

    @Override
    public SoapQueryResponse mapResponseBySource(ConsultarResponse source) {
        return this.requestMapperByMapstruct.mapperQueryResponse(source);
    }
}
