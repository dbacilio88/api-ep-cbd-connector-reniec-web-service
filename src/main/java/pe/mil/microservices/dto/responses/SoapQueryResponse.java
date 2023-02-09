package pe.mil.microservices.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoapQueryResponse {

    private SoapQueryResult result;
}
