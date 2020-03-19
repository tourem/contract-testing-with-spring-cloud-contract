package com.larbotech.consumer.scc.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.larbotech.consumer.scc.commands.AccountCommand;
import com.larbotech.consumer.scc.domains.Account;
import com.larbotech.consumer.scc.repositories.AccountRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AccountService {

  private AccountRepository accountRepository;
  public static final String URL = "http://localhost:8081/api/users";

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Map<String, String> createAccount(AccountCommand accountCommand) {

    RestTemplate restTemplate = new RestTemplate();
    Map<String, String> response = new HashMap<>();
    Map<String, String> request_body = new HashMap<>();

    request_body.put("fullName", accountCommand.getFullName());
    request_body.put("phone", accountCommand.getPhone());

    //UserCommand userCommand=new UserCommand(accountCommand.getFullName(),accountCommand.getPhone());
    String accountId = UUID.randomUUID().toString();

    JsonNode userResponse = restTemplate.postForObject(URL, request_body, JsonNode.class);

    response.put("account_id", accountId);
    response.put("user_id", userResponse.get("id").asText());
    accountRepository.save(
        new Account(accountId, userResponse.get("id").asText(), accountCommand.getEmail(),
            accountCommand.getDesc()));
    return response;
  }

  public Map<String, String> createAnonymousAccount() {

    return createAccount(
        new AccountCommand("Anonymous", "123456789", "test@Anonymous.test", "Anonymous account"));
  }

  public List<Account> getAllaccounts() {

    return accountRepository.findAll();
  }

  public Account getAccountDetails(String id) {
    return accountRepository.findByAccountId(id);
  }

}
