package pe.mil.microservices.controllers.base;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.support.WebExchangeBindException;
import pe.mil.microservices.utils.components.enums.ResponseCode;
import pe.mil.microservices.utils.components.exceptions.CommonBusinessProcessException;
import pe.mil.microservices.utils.constants.BaseInterceptorConstants;
import pe.mil.microservices.utils.dtos.base.BusinessResponse;
import pe.mil.microservices.utils.dtos.process.BusinessProcessResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Log4j2
public class ReactorBaseController {
    private final BusinessResponse businessResponse;
    private final String militarControllerId;

    private final Gson gson;

    public ReactorBaseController(final String controllerName, final BusinessResponse businessResponse) {
        this.gson = new Gson();
        this.businessResponse = businessResponse;
        this.militarControllerId = UUID.randomUUID().toString();
        log.debug("services name {}, controllerId {}", controllerName, militarControllerId);
        log.debug("{} loaded successfully", controllerName);
    }

    public String getMilitarControllerId() {
        return this.militarControllerId;
    }


    public Mono<ResponseEntity<Object>> getResponseEntity(BusinessProcessResponse businessProcessResponse) {
        return Mono.just(businessProcessResponse)
            .flatMap(process -> {

                if (process.isErrorProcessResponse() && Objects.isNull(process.getBusinessResponse()) || process.isEmptySuccessfullyResponse()) {
                    log.info(BaseInterceptorConstants.RESPONSE_MESSAGE, gson.toJson(businessResponse.getResponse(businessProcessResponse.getResponseCode().getResponseCodeValue())));
                    return Mono.just(this.businessResponse.getResponse(businessProcessResponse.getResponseCode().getResponseCodeValue()));
                }

                log.info(BaseInterceptorConstants.RESPONSE_MESSAGE, gson.toJson(businessResponse.getResponse(businessProcessResponse.getResponseCode().getResponseCodeValue())));

                return Mono.just(this.businessResponse.getResponse(businessProcessResponse.getBusinessResponse(), businessProcessResponse.getResponseCode().getResponseCodeValue()));
            })
            .onErrorResume(throwable -> Mono.just(this.businessResponse.getResponse(ResponseCode.INTERNAL_SERVER_ERROR.getResponseCodeValue()))
            );
    }

    public Mono<ResponseEntity<Object>> getResponseEntity(Mono<BusinessProcessResponse> businessResponseProcess, String method) {
        return businessResponseProcess
            .flatMap(process -> {
                log.info("process {} ", process.getResponseCode().getResponseCodeValue());
                if (process.isErrorProcessResponse() && Objects.isNull(process.getBusinessResponse()) || process.isEmptySuccessfullyResponse()) {
                    log.info(BaseInterceptorConstants.RESPONSE_MESSAGE, gson.toJson(businessResponse.getResponse(process.getResponseCode().getResponseCodeValue())));
                    return Mono.just(businessResponse.getResponse(process.getResponseCode().getResponseCodeValue()));
                }
                log.info(BaseInterceptorConstants.RESPONSE_MESSAGE, gson.toJson(businessResponse.getResponse(process.getResponseCode().getResponseCodeValue())));
                return Mono.just(businessResponse.getResponse(process.getBusinessResponse(), process.getResponseCode().getResponseCodeValue()));
            })
            .doOnSuccess(success -> log.info("finish process {} ", method))
            .onErrorResume(WebExchangeBindException.class, Mono::error)
            .onErrorResume(CommonBusinessProcessException.class, e -> Mono.just(businessResponse.getResponse(e.getResponseCode().getResponseCodeValue())))
            .doOnError(throwable -> log.error("exception error in process {}, error: {}", method, throwable.getMessage()));
        //.onErrorResume(throwable -> Mono.just(this.businessResponse.getResponse(ResponseCode.INTERNAL_SERVER_ERROR.getResponseCodeValue())));
    }

    public Mono<ResponseEntity<Object>> getInternalServerError() {
        final String response = gson.toJson(businessResponse.getResponse(ResponseCode.SUCCESS_IN_REQUESTED_DATA_NOT_FOUND.getResponseCodeValue()));
        log.info(BaseInterceptorConstants.RESPONSE_MESSAGE, response);
        return Mono.just(businessResponse.getResponse(ResponseCode.SUCCESS_IN_REQUESTED_DATA_NOT_FOUND.getResponseCodeValue()));
    }
}
