package pe.mil.microservices.components.mappers.contracts;

import javax.annotation.processing.Generated;
import pe.mil.microservices.components.connectors.reniec.PeticionConsulta;
import pe.mil.microservices.dto.requests.ReniecQueryRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T11:19:01-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16 (OpenLogic)"
)
public class IReniecRequestMapperByMapstructImpl implements IReniecRequestMapperByMapstruct {

    @Override
    public PeticionConsulta mapPetitionQueryByReniecQueryRequest(ReniecQueryRequest source) {
        if ( source == null ) {
            return null;
        }

        PeticionConsulta peticionConsulta = new PeticionConsulta();

        peticionConsulta.setNuDniUsuario( source.getUserDocumentNumber() );
        peticionConsulta.setNuRucUsuario( source.getRucNumber() );
        peticionConsulta.setPassword( source.getPassword() );
        peticionConsulta.setNuDniConsulta( source.getQueryDocumentNumber() );

        return peticionConsulta;
    }
}
