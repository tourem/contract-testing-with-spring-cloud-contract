package com.larbotech.provider.scc.repositories;

import com.larbotech.provider.scc.domains.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {

  List<Book> findByAuthor(String author);

  List<Book> findByTitleLike(String title);
}
