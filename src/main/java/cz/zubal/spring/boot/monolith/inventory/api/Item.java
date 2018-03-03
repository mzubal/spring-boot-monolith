package cz.zubal.spring.boot.monolith.inventory.api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {

  private String uuid;
  private String type;
  private String name;
  private BigDecimal price;
  private String description;

}
