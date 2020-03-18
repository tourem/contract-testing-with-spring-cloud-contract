package com.larbotech.provider.scc.services;

import com.larbotech.provider.scc.domains.Book;
import com.larbotech.provider.scc.repositories.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


  @Autowired
  BookRepository bookRepository;


  public Book createNew(Book book) {
    return bookRepository.save(book);
  }


  public Book update(String isbn, Book book) {
    Optional<Book> retrievedBook = bookRepository.findById(isbn);
    if (retrievedBook.isPresent()) {
      Book b = retrievedBook.get();
      b.setAuthor(book.getAuthor());
      b.setTitle(book.getTitle());
      return bookRepository.save(b);
    }
    return null;
  }


  public Optional<Book> findByIsbn(String isbn) {
    return bookRepository.findById(isbn);

  }

  public List<Book> findByAuthor(String author) {
    return bookRepository.findByAuthor(author);
  }


  public List<Book> findByTitleLike(String title) {
    return bookRepository.findByTitleLike(title);
  }


  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public void delete(Book book) {
    bookRepository.delete(book);
  }

}

