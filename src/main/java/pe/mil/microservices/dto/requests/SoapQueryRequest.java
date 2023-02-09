package pe.mil.microservices.dto.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoapQueryRequest {

    private ReniecQueryRequest query;

}

