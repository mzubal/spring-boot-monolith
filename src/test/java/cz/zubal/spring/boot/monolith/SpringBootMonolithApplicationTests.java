package cz.zubal.spring.boot.monolith;

import com.google.common.collect.ImmutableList;
import cz.zubal.spring.boot.monolith.customer.api.Customer;
import cz.zubal.spring.boot.monolith.customer.api.CustomerService;
import cz.zubal.spring.boot.monolith.inventory.api.Item;
import cz.zubal.spring.boot.monolith.inventory.api.ItemService;
import cz.zubal.spring.boot.monolith.order.api.Order;
import cz.zubal.spring.boot.monolith.order.api.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMonolithApplicationTests {

	@Autowired
	OrderService orderService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ItemService itemService;

	@Test
	public void simpleIntegrationTest() {
		Customer customer = new Customer();
		customer.setUsername("milos");
		customer.setFirstName("Milos");
		customer.setLastName("Zubal");
		customerService.create(customer);

		Item item = new Item();
		item.setUuid("item-1");
		item.setName("vim");
		item.setDescription("Text editor to learn.");
		item.setType("Text Editor");
		item.setPrice(new BigDecimal(0));
		itemService.create(item);

		Order order = new Order();
		order.setCustomer(customer);
		order.setItems(ImmutableList.of(item));
		orderService.create(order);
	}
}
