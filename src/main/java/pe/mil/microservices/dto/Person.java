package pe.mil.microservices.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person implements Serializable {

    private static final long serialVersionUID = 2316985525571890303L;

    protected String lastName;
    protected String motherLastName;
    protected String address;
    protected String civilStatus;
    protected byte[] photo;
    protected String names;
    protected String restriction;
    protected String location;
}
