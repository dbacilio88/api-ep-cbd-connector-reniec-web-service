package pe.mil.microservices.connectors.soap.mappers.contracts;

import org.mapstruct.*;
import pe.mil.microservices.connectors.wsdl.reniec.Consultar;
import pe.mil.microservices.connectors.wsdl.reniec.ConsultarResponse;
import pe.mil.microservices.dto.requests.SoapQueryRequest;
import pe.mil.microservices.dto.responses.SoapQueryResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface IReniecQueryRequestMapperByMapstruct {

    @Mappings({
        @Mapping(source = "query.userDocumentNumber", target = "arg0.nuDniUsuario"),
        @Mapping(source = "query.queryDocumentNumber", target = "arg0.nuDniConsulta"),
        @Mapping(source = "query.password", target = "arg0.password"),
        @Mapping(source = "query.rucNumber", target = "arg0.nuRucUsuario"),
    })
    Consultar mapperQueryRequest(SoapQueryRequest request);

    @Mappings({
        @Mapping(source = "return.coResultado", target = "result.resultCode"),
        @Mapping(source = "return.deResultado", target = "result.resultDescription"),
        @Mapping(source = "return.datosPersona.apPrimer", target = "result.person.lastName"),
        @Mapping(source = "return.datosPersona.apSegundo", target = "result.person.motherLastName"),
        @Mapping(source = "return.datosPersona.direccion", target = "result.person.address"),
        @Mapping(source = "return.datosPersona.foto", target = "result.person.photo"),
        @Mapping(source = "return.datosPersona.estadoCivil", target = "result.person.civilStatus"),
        @Mapping(source = "return.datosPersona.prenombres", target = "result.person.names"),
        @Mapping(source = "return.datosPersona.restriccion", target = "result.person.restriction"),
        @Mapping(source = "return.datosPersona.ubigeo", target = "result.person.location"),
    })
    SoapQueryResponse mapperQueryResponse(ConsultarResponse response);

}
