package com.larbotech.provider.scc.domains;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  private String userID;
  private String fullName;
  private String phone;
}
