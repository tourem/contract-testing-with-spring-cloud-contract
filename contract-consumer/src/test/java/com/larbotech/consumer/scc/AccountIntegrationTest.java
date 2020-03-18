package com.larbotech.consumer.scc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.larbotech.consumer.scc.commands.AccountCommand;
import com.larbotech.consumer.scc.services.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

public class AccountIntegrationTest extends BaseTestClass {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private AccountService accountService;

  @Test
  public void givenAccountID_thenReturnAccountDetails()
      throws Exception {

    accountService
        .createAccount(new AccountCommand("HelloWorld", "123334556", "abc@test.com", "test"));

    mockMvc.perform(get("/account/")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].desc", is("test")));

  }


}