package cz.zubal.spring.boot.monolith.order;

import cz.zubal.spring.boot.monolith.customer.api.CustomerService;
import cz.zubal.spring.boot.monolith.inventory.api.ItemService;
import cz.zubal.spring.boot.monolith.order.api.Order;
import cz.zubal.spring.boot.monolith.order.api.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
class RepositoryOrderService implements OrderService {

  @Autowired
  CustomerService customerService;

  @Autowired
  ItemService itemService;

  @Autowired
  OrderRepo orderRepo;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public List<Order> list() {
    return StreamSupport.stream(orderRepo.findAll().spliterator(), false)
       .map(this::mapToApiOrder)
       .collect(Collectors.toList());
  }


  @Override
  public Order findByUuid(String uuid) {
    return mapToApiOrder(orderRepo.findByUuid(uuid));
  }

  @Override
  public Order create(Order order) {
    OrderEntity orderEntity = modelMapper.map(order, OrderEntity.class);
    orderEntity.setUsername(order.getCustomer().getUsername());
    orderEntity.setItems(order.getItems().stream().map(i -> i.getUuid()).collect(Collectors.toList()));
    return mapToApiOrder(orderRepo.save(orderEntity));
  }

  private Order mapToApiOrder(OrderEntity dbOrder) {
    Order order = modelMapper.map(dbOrder, Order.class);
    order.setCustomer(customerService.findByUsername(dbOrder.getUsername()));
    order.setItems(itemService.findByUuids(dbOrder.getItems()));
    return order;
  }

}
