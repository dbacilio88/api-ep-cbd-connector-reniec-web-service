package pe.mil.microservices.components.validations;

import pe.mil.microservices.components.enums.ReniecValidationResult;
import pe.mil.microservices.dto.requests.ReniecQueryRequest;

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface IReniecValidation
    extends Function<ReniecQueryRequest, ReniecValidationResult> {

    static IReniecValidation isReniecRucValidation() {
        return request ->
            request.getRucNumber() != null

                && !request.getRucNumber().isEmpty()
                && !request.getRucNumber().isBlank()

                ? ReniecValidationResult.RENIEC_VALID
                : ReniecValidationResult.INVALID_RENIEC_RUC;
    }

    static IReniecValidation isReniecPasswordValidation() {
        return request ->
            request.getPassword() != null
                && !request.getRucNumber().isEmpty()
                && !request.getRucNumber().isBlank()
                ? ReniecValidationResult.RENIEC_VALID
                : ReniecValidationResult.INVALID_RENIEC_PASSWORD;
    }


    static IReniecValidation isReniecDniUserValidation() {
        return request ->
            request.getUserDocumentNumber() != null
                && !request.getUserDocumentNumber().isBlank()
                && !request.getUserDocumentNumber().isEmpty()
                ? ReniecValidationResult.RENIEC_VALID
                : ReniecValidationResult.INVALID_RENIEC_DNI_USER;
    }

    static IReniecValidation isReniecDniQueryValidation() {
        return request ->
            request.getQueryDocumentNumber() != null
                && !request.getQueryDocumentNumber().isBlank()
                && !request.getQueryDocumentNumber().isEmpty()
                ? ReniecValidationResult.RENIEC_VALID
                : ReniecValidationResult.INVALID_RENIEC_DNI_QUERY;
    }

    static IReniecValidation customValidation(Predicate<ReniecQueryRequest> validate) {
        return request -> validate.test(request)
            ? ReniecValidationResult.RENIEC_VALID
            : ReniecValidationResult.INVALID_RENIEC_DNI_QUERY;
    }

    default IReniecValidation and(IReniecValidation andValidation) {
        return request -> {
            ReniecValidationResult validation = this.apply(request);
            return validation.equals(ReniecValidationResult.RENIEC_VALID)
                ? andValidation.apply(request)
                : validation;
        };
    }

    default IReniecValidation or(IReniecValidation orValidation) {
        return request -> {
            ReniecValidationResult validation = this.apply(request);
            return validation.equals(ReniecValidationResult.RENIEC_VALID)
                ? orValidation.apply(request)
                : validation;
        };
    }
}
