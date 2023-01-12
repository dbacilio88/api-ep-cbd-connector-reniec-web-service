package pe.mil.microservices.dto.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReniecQueryRequest implements Serializable {

    private static final long serialVersionUID = -6368936801983933510L;

    private String userDocumentNumber;
    private String rucNumber;
    private String password;
    private String queryDocumentNumber;
}
