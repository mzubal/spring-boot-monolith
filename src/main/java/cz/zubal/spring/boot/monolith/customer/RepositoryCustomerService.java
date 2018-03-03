package cz.zubal.spring.boot.monolith.customer;

import cz.zubal.spring.boot.monolith.customer.api.Customer;
import cz.zubal.spring.boot.monolith.customer.api.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
class RepositoryCustomerService implements CustomerService {

  @Autowired
  CustomerRepo customerRepo;

  @Autowired
  ModelMapper modelMapper;

  Type customerListType = new TypeToken<List<Customer>>() {}.getType();

  @Override
  public List<Customer> list() {
    return modelMapper.map(customerRepo.findAll(), customerListType);
  }

  @Override
  public Customer findByUsername(String username) {
    return modelMapper.map(customerRepo.findByUsername(username), Customer.class);
  }

  @Override
  public void create(Customer customer) {
    customerRepo.save(modelMapper.map(customer, CustomerEntity.class));
  }
}
