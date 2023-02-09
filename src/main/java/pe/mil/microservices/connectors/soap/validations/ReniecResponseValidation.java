package pe.mil.microservices.connectors.soap.validations;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import pe.mil.microservices.components.validations.ISoapValidationResponse;
import pe.mil.microservices.components.wsdl.SoapValidationResult;
import pe.mil.microservices.connectors.wsdl.reniec.ConsultarResponse;
import pe.mil.microservices.dto.responses.SoapQueryResponse;
import pe.mil.microservices.utils.components.enums.ValidateResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Log4j2
@Component
public class ReniecResponseValidation implements ISoapValidationResponse<ConsultarResponse> {

    @Override
    public SoapValidationResult validateResponse(ConsultarResponse response) {

        final SoapValidationResult validationResult = SoapValidationResult
            .builder()
            .validateResult(ValidateResult.SUCCESSFULLY_VALID)
            .build();

        final List<String> errors = new ArrayList<>();

        if (Objects.isNull(response)) {
            log.error("error the response is null");
            errors.add("error the response is null");
        }

        if (!errors.isEmpty()) {
            validationResult.setValidateResult(ValidateResult.NOT_VALID);
            validationResult.setErrors(errors);
        }
        return validationResult;
    }
}
