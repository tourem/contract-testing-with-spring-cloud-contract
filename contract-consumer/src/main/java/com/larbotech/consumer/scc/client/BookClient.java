package com.larbotech.consumer.scc.client;

import com.larbotech.consumer.scc.domains.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("bookservice")
public interface BookClient {

  @RequestMapping(method = RequestMethod.GET, path = "/api/books/{isbn}", consumes = MediaType.APPLICATION_JSON_VALUE)
  Book getBook(@PathVariable("isbn") String isbn);

  @RequestMapping(method = RequestMethod.POST, path = "/api/books", consumes = MediaType.APPLICATION_JSON_VALUE)
  Book createBook(@RequestBody Book book);


}
