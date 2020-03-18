package com.larbotech.provider.scc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.larbotech.provider.scc.controllers.BookController;
import com.larbotech.provider.scc.controllers.UserController;
import com.larbotech.provider.scc.domains.Book;
import com.larbotech.provider.scc.repositories.BookRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.Optional;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

@SpringBootTest(classes = ProviderApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BaseTestClass {

  @Autowired
  private UserController userController;

  @Autowired
 private BookController bookController;

  @MockBean
  private BookRepository repository;


  @Before
  public void setup() {
    Book book = new Book("123", "Ferok Book", "Fero Hero");
    when(repository.findById(any(String.class))).thenReturn(Optional.of(book));
    when(repository.save(any(Book.class))).thenReturn(book);

    //RestAssuredMockMvc.webAppContextSetup(webApplicationContext);       // mocks all controllers
    StandaloneMockMvcBuilder standaloneMockMvcBuilder
        = MockMvcBuilders.standaloneSetup(userController, bookController);
    RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
  }
}