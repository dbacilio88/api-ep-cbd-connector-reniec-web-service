package pe.mil.microservices.dto.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pe.mil.microservices.dto.Person;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoapQueryResult {

    protected String resultCode;
    protected Person person;
    protected String resultDescription;
}
