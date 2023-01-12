package pe.mil.microservices.components.mappers.contracts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pe.mil.microservices.components.connectors.reniec.PeticionConsulta;
import pe.mil.microservices.dto.requests.ReniecQueryRequest;
import static pe.mil.microservices.components.mappers.contracts.IReniecRequestMapperByMapstruct.CustomerFields.*;

@Mapper
public interface IReniecRequestMapperByMapstruct {

    IReniecRequestMapperByMapstruct QUERY_RENIEC_REQUEST_MAPPER = Mappers
        .getMapper(IReniecRequestMapperByMapstruct.class);

    @Mapping(source = FIELD_RENIEC_USER_DOCUMENT_NUMBER_SOURCE, target = FIELD_NU_DNI_USER_TARGET)
    @Mapping(source = FIELD_RENIEC_RUC_NUMBER_SOURCE, target = FIELD_NU_RUC_USER_TARGET)
    @Mapping(source = FIELD_RENIEC_PASSWORD_SOURCE, target = FIELD_PASSWORD_TARGET)
    @Mapping(source = FIELD_QUERY_DOCUMENT_NUMBER_SOURCE, target = FIELD_NU_DNI_CONSULT_TARGET)
    PeticionConsulta mapPetitionQueryByReniecQueryRequest(ReniecQueryRequest source);


    class CustomerFields {
        public static final String FIELD_RENIEC_USER_DOCUMENT_NUMBER_SOURCE = "userDocumentNumber";
        public static final String FIELD_RENIEC_RUC_NUMBER_SOURCE = "rucNumber";
        public static final String FIELD_RENIEC_PASSWORD_SOURCE = "password";
        public static final String FIELD_QUERY_DOCUMENT_NUMBER_SOURCE = "queryDocumentNumber";
        public static final String FIELD_NU_DNI_USER_TARGET = "nuDniUsuario";
        public static final String FIELD_NU_RUC_USER_TARGET = "nuRucUsuario";
        public static final String FIELD_PASSWORD_TARGET = "password";
        public static final String FIELD_NU_DNI_CONSULT_TARGET = "nuDniConsulta";
    }
}
