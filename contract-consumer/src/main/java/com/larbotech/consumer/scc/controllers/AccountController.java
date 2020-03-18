package com.larbotech.consumer.scc.controllers;


import com.larbotech.consumer.scc.commands.AccountCommand;
import com.larbotech.consumer.scc.domains.Account;
import com.larbotech.consumer.scc.services.AccountService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {


  private AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping("/create")
  public Map<String, String> createAccount(@RequestBody AccountCommand accountCommand) {

    return accountService.createAccount(accountCommand);

  }

  @GetMapping("/")
  public List<Account> getAllaccounts() {
    return accountService.getAllaccounts();
  }

  @GetMapping("/{id}")
  public Account getAccountDetails(@PathVariable String id) {
    return accountService.getAccountDetails(id);
  }
}
