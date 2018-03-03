package cz.zubal.spring.boot.monolith.customer.api;

import java.util.List;

public interface CustomerService {

  List<Customer> list();

  Customer findByUsername(String username);

  void create(Customer customer);

}
