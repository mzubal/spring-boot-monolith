package cz.zubal.spring.boot.monolith.order.api;

import java.util.List;

public interface OrderService {

  List<Order> list();
  Order findByUuid(String uuid);
  Order create(Order order);

}
