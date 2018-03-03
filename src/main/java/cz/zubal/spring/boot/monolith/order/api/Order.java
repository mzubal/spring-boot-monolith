package cz.zubal.spring.boot.monolith.order.api;

import cz.zubal.spring.boot.monolith.customer.api.Customer;
import cz.zubal.spring.boot.monolith.inventory.api.Item;
import lombok.Data;

import java.util.List;

@Data
public class Order {

  private String uuid;
  private Customer customer;
  private List<Item> items;

}
