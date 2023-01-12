package pe.mil.microservices.repositories.entities;

import lombok.*;
import pe.mil.microservices.constants.RepositoryEntitiesConstants;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@Table(name = RepositoryEntitiesConstants.ENTITY_CUSTOMER_DEMO)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = RepositoryEntitiesConstants.ENTITY_CUSTOMER_DEMO_ID)
    private Long customerId;

    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Column(name = "DESCRIPTION")
    private String description;
}
