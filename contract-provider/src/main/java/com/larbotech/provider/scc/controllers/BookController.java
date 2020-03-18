package com.larbotech.provider.scc.controllers;

import com.larbotech.provider.scc.domains.Book;
import com.larbotech.provider.scc.services.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  BookService bookService;

  @RequestMapping(
      method = RequestMethod.POST,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public Book createBook(@RequestBody Book book) {
    return bookService.createNew(book);
  }

  @RequestMapping(value = "/{isbn}",
      method = RequestMethod.PUT,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public Book updateBook(@PathVariable String isbn, @RequestBody Book book) {

    return bookService.update(isbn, book);
  }

  @RequestMapping(value = "/{isbn}",
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public Optional<Book> getByIsbn(@PathVariable String isbn) {
    return bookService.findByIsbn(isbn);
  }

  @RequestMapping(
      params = {"author"},
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public List<Book> getByAuthor(@RequestParam(value = "author") String author) {
    return bookService.findByAuthor(author);
  }


  @RequestMapping(
      params = {"title"},
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public List<Book> getByTitle(@RequestParam(value = "title") String title) {
    return bookService.findByTitleLike(title);
  }


  @RequestMapping(
      method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public List<Book> getAll() {
    return bookService.findAll();
  }
}
