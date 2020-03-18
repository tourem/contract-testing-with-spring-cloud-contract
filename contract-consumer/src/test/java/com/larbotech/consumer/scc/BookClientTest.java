package com.larbotech.consumer.scc;

import com.larbotech.consumer.scc.client.BookClient;
import com.larbotech.consumer.scc.domains.Book;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class BookClientTest extends BaseTestClass {

  @Autowired
  private BookClient bookClient;

  @Test
  public void getBookByisbnCompliesToContract() {
    Book book = bookClient.getBook("123");
    Assertions.assertThat(book.getIsbn()).isEqualToIgnoringCase("123");
  }

  @Test
  public void createBookCompliesToContract() {
    Book book = new Book("123", "Ferok Book", "Fero Hero");
    Book createdBook = bookClient.createBook(book);
    Assertions.assertThat(createdBook.getIsbn()).isEqualToIgnoringCase("123");
  }
}
