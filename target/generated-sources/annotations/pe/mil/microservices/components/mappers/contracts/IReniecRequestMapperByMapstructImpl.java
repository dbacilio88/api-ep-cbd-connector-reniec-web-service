package pe.mil.microservices.components.mappers.contracts;

import javax.annotation.processing.Generated;
import pe.mil.microservices.components.connectors.reniec.PeticionConsulta;
import pe.mil.microservices.dto.requests.ReniecQueryRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-08T00:26:22-0500",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20221215-1352, environment: Java 17.0.5 (Eclipse Adoptium)"
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
