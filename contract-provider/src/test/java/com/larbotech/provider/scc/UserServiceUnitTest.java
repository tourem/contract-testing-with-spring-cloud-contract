package com.larbotech.provider.scc;

import com.larbotech.provider.scc.domains.User;
import com.larbotech.provider.scc.repositories.UserRepository;
import com.larbotech.provider.scc.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class UserServiceUnitTest {


  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @Before
  public void setUp() {
    User superman = new User("1", "superman", "123456789");

    Mockito.when(userRepository.findByUserID("1"))
        .thenReturn(superman);

  }

  @Test
  public void whenValidId_thenUserShouldBeFound() {

    String id = "1";
    User user = userService.getUserById(id);
    Assert.assertEquals("superman", user.getFullName());

  }

}