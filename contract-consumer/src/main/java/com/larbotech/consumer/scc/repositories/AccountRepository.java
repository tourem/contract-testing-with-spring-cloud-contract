package com.larbotech.consumer.scc.repositories;

import com.larbotech.consumer.scc.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

  Account findByAccountId(String id);

}
