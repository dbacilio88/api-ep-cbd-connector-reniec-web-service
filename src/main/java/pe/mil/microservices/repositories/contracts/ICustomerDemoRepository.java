package pe.mil.microservices.repositories.contracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.mil.microservices.repositories.entities.CustomerEntity;

@Repository
public interface ICustomerDemoRepository extends JpaRepository<CustomerEntity, Long> {
    boolean existsByCustomerId(Long customerId);


}
