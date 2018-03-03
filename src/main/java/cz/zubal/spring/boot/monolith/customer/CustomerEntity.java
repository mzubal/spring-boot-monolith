package cz.zubal.spring.boot.monolith.customer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
class CustomerEntity {

  @Id @GeneratedValue
  private Long id;

  private String username;
  private String firstName;
  private String lastName;

}
