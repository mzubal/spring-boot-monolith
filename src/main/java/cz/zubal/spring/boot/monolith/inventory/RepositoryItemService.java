package cz.zubal.spring.boot.monolith.inventory;

import cz.zubal.spring.boot.monolith.customer.api.Customer;
import cz.zubal.spring.boot.monolith.inventory.api.Item;
import cz.zubal.spring.boot.monolith.inventory.api.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class RepositoryItemService implements ItemService {

  @Autowired
  ItemRepo itemRepo;

  @Autowired
  ModelMapper modelMapper;

  Type customerListType = new TypeToken<List<Customer>>() {}.getType();

  @Override
  public List<Item> list() {
    return modelMapper.map(itemRepo.findAll(), customerListType);
  }

  @Override
  public Item findByUuid(String uuid) {
    return modelMapper.map(itemRepo.findByUuid(uuid), Item.class);
  }

  @Override
  public List<Item> findByUuids(List<String> uuids) {
    return modelMapper.map(itemRepo.findAllByUuidIn(uuids), customerListType);
  }

  @Override
  public Item create(Item item) {
    ItemEntity dbItem = itemRepo.save(modelMapper.map(item, ItemEntity.class));
    return modelMapper.map(dbItem, Item.class);
  }
}
