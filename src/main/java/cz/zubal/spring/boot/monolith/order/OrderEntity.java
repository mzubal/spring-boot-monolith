package cz.zubal.spring.boot.monolith.order;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class OrderEntity {

  @Id @GeneratedValue
  private Long id;

  private String uuid;
  private String username;

  @ElementCollection
  private List<String> items;

}
