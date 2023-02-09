package pe.mil.microservices.connectors.soap.definitions;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import pe.mil.microservices.components.configurations.MicroservicesSoapConfiguration;
import pe.mil.microservices.components.mappers.contracts.ISoapMapperRequest;
import pe.mil.microservices.components.mappers.contracts.ISoapMapperResponse;
import pe.mil.microservices.components.mappers.implementations.SoapMapperRequest;
import pe.mil.microservices.components.mappers.implementations.SoapMapperResponse;
import pe.mil.microservices.components.validations.ISoapValidationRequest;
import pe.mil.microservices.components.validations.ISoapValidationResponse;
import pe.mil.microservices.connectors.wsdl.reniec.Consultar;
import pe.mil.microservices.connectors.wsdl.reniec.ConsultarResponse;
import pe.mil.microservices.dto.requests.SoapQueryRequest;
import pe.mil.microservices.dto.responses.SoapQueryResponse;
import pe.mil.microservices.dtos.request.SoapClientRequest;
import pe.mil.microservices.services.abstractions.contracts.ISoapCustomDefinition;
import pe.mil.microservices.services.abstractions.contracts.ISoapStandardDefinition;

import static pe.mil.microservices.constants.SoapDefinitionsConstants.RENIEC_STANDARD_DEFINITION;

@Log4j2
@Component(RENIEC_STANDARD_DEFINITION)
public class ReniecCustomDefinition implements ISoapCustomDefinition {

    private final MicroservicesSoapConfiguration microservicesSoapConfiguration;

    private final SoapMapperRequest<SoapQueryRequest, Consultar> soapMapperRequest;
    private final SoapMapperResponse<ConsultarResponse, SoapQueryResponse> soapMapperResponse;
    private final ISoapValidationRequest<Consultar> soapValidationRequest;
    private final ISoapValidationResponse<ConsultarResponse> soapValidationResponse;

    public ReniecCustomDefinition(
        final MicroservicesSoapConfiguration microservicesSoapConfiguration,
        final ISoapValidationRequest<Consultar> soapValidationRequest,
        final ISoapValidationResponse<ConsultarResponse> soapValidationResponse,
        final SoapMapperRequest<SoapQueryRequest, Consultar> soapMapperRequest,
        final SoapMapperResponse<ConsultarResponse, SoapQueryResponse> soapMapperResponse
    ) {
        this.microservicesSoapConfiguration = microservicesSoapConfiguration;
        this.soapValidationRequest = soapValidationRequest;
        this.soapValidationResponse = soapValidationResponse;
        this.soapMapperRequest = soapMapperRequest;
        this.soapMapperResponse = soapMapperResponse;

        log.info("uri {}", this.microservicesSoapConfiguration.getReniecSoapService().getServiceUri());
        log.info("path {}", this.microservicesSoapConfiguration.getReniecSoapService().getServiceGeneratorWsdlPath());

    }

    @Override
    public <BT, ST> ISoapMapperRequest<BT, ST> soapMapperRequest() {
        return (ISoapMapperRequest<BT, ST>) soapMapperRequest;
    }

    @Override
    public <SR, BR> ISoapMapperResponse<SR, BR> soapMapperResponse() {
        return (ISoapMapperResponse<SR, BR>) soapMapperResponse;
    }

    @Override
    public <ST> ISoapValidationRequest<ST> validateSoapRequest() {
        return (ISoapValidationRequest<ST>) soapValidationRequest;
    }

    @Override
    public <SR> ISoapValidationResponse<SR> validateSoapResponse() {
        return (ISoapValidationResponse<SR>) soapValidationResponse;
    }

    @Override
    public <ST> SoapClientRequest<ST> buildSoapClientRequest(ST soapRequest) {
        return (SoapClientRequest<ST>) SoapClientRequest
            .<Consultar>builder()
            .configuration(microservicesSoapConfiguration.getReniecSoapService())
            .classOfResponse(ConsultarResponse.class)
            .soapRequest((Consultar) soapRequest)
            .build();
    }
}
