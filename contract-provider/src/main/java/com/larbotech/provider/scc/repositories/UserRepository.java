package com.larbotech.provider.scc.repositories;

import com.larbotech.provider.scc.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

  User findByUserID(String Id);
}
