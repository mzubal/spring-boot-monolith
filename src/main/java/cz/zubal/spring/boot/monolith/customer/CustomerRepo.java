package cz.zubal.spring.boot.monolith.customer;

import org.springframework.data.repository.CrudRepository;

interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {

  CustomerEntity findByUsername(String username);

}
