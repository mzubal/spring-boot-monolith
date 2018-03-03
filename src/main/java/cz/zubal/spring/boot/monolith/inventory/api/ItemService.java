package cz.zubal.spring.boot.monolith.inventory.api;

import java.util.List;

public interface ItemService {

  List<Item> list();

  Item findByUuid(String uuid);

  List<Item> findByUuids(List<String> uuids);

  Item create(Item item);

}
