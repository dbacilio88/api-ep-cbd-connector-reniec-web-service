package pe.mil.microservices.services.implementations;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pe.mil.microservices.components.connectors.clients.ReniecClientWsdl;
import pe.mil.microservices.components.connectors.reniec.ConsultarResponse;
import pe.mil.microservices.components.connectors.reniec.DatosPersona;
import pe.mil.microservices.components.connectors.reniec.PeticionConsulta;
import pe.mil.microservices.components.enums.ReniecValidationResult;
import pe.mil.microservices.components.mappers.contracts.IReniecRequestMapperByMapstruct;
import pe.mil.microservices.components.validations.IReniecValidation;
import pe.mil.microservices.dto.Person;
import pe.mil.microservices.dto.requests.ReniecQueryRequest;
import pe.mil.microservices.services.contracts.IPersonQueryService;
import pe.mil.microservices.utils.components.enums.ResponseCode;
import pe.mil.microservices.utils.components.exceptions.CommonBusinessProcessException;
import pe.mil.microservices.utils.dtos.base.GenericBusinessResponse;
import pe.mil.microservices.utils.dtos.process.BusinessProcessResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Log4j2
@Service
public class PersonQueryService implements IPersonQueryService {

    private final ReniecClientWsdl client;
    private final String personQueryServiceId;

    public PersonQueryService(ReniecClientWsdl client) {
        this.client = client;
        personQueryServiceId = UUID.randomUUID().toString();
        log.debug("personQueryServiceId {}", personQueryServiceId);
        log.debug("PersonQueryService loaded successfully");
    }

    @Override
    public Mono<BusinessProcessResponse> query(Mono<ReniecQueryRequest> entity) {

        return entity
            .flatMap(request -> {
                log.debug("this is in services reniec method");
                log.info("this is in services reniec method");

                final ReniecValidationResult validation = IReniecValidation
                    .isReniecDniQueryValidation().apply(request);
                log.info("validation {} ", validation);
                if (!ReniecValidationResult.RENIEC_VALID.equals(validation)) {
                    return Mono
                        .error(() -> new CommonBusinessProcessException(ResponseCode.ERROR_IN_REQUESTED_DATA));

                }
                log.info("return request {} ", request);
                return Mono.just(request);
            })
            .flatMap(request -> {
                final PeticionConsulta query = IReniecRequestMapperByMapstruct.QUERY_RENIEC_REQUEST_MAPPER.mapPetitionQueryByReniecQueryRequest(request);
                log.info("query request {} ", query.toString());

                return this.client.getResultQueryReniecPerson(query)
                    .flatMap(cr -> {
                        log.info("cr response {} ", cr.toString());
                        if (Objects.isNull(cr)) {
                            return Mono
                                .error(() -> new CommonBusinessProcessException(ResponseCode.ERROR_IN_REQUESTED_DATA));
                        }

                        return Mono.just(cr);
                    });
            })
            .flatMap(response -> {

                log.info("response response {} ", response);

                if (Objects.isNull(response)) {
                    return Mono
                        .error(() -> new CommonBusinessProcessException(ResponseCode.ERROR_IN_REQUESTED_DATA));
                }

                log.info("response response {} ", response);

                if (!response.getReturn().getCoResultado().equals("0000")) {
                    return Mono
                        .error(() -> new CommonBusinessProcessException(ResponseCode.ERROR_IN_REQUESTED_DATA));
                }

                GenericBusinessResponse<Person> generic = new GenericBusinessResponse<>();
                DatosPersona data = response.getReturn().getDatosPersona();

                generic.setData(
                    Person
                        .builder()
                        .names(data.getPrenombres())
                        .photo(data.getFoto())
                        .address(data.getDireccion())
                        .civilStatus(data.getEstadoCivil())
                        .lastName(data.getApPrimer())
                        .location(data.getUbigeo()).build()
                );
                return Mono.just(generic);

            })
            .flatMap(generic -> Mono.just(
                BusinessProcessResponse
                    .setEntitySuccessfullyResponse(new GenericBusinessResponse<>(generic)))
            )
            .doOnSuccess(success ->
                log.info("finish process query reniec, success: {}", success)
            )
            .doOnError(throwable ->
                log.error("exception error in process query reniec, error: {}", throwable.getMessage())
            ).log();
    }
}
