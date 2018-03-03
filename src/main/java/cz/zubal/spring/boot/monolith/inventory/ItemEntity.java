package cz.zubal.spring.boot.monolith.inventory;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
class ItemEntity {

  @Id @GeneratedValue
  private Long id;

  private String uuid;
  private String type;
  private String name;
  private BigDecimal price;
  private String description;

}
