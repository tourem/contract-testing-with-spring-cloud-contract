package com.larbotech.consumer.scc.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCommand {

  private String fullName;
  private String phone;
  private String email;
  private String desc;
}
