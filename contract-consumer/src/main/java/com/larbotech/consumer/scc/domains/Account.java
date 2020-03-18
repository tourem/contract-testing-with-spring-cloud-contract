package com.larbotech.consumer.scc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

  @Id
  private String accountId;
  private String userId;
  private String email;
  private String desc;

}
