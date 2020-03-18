package com.larbotech.consumer.scc.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  private String isbn;
  private String title;
  private String author;
}