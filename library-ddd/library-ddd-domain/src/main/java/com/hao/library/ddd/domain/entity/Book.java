package com.hao.library.ddd.domain.entity;

import com.hao.library.ddd.types.book.*;
import com.hao.library.ddd.types.category.CategoryId;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Book {
    private BookId bookId;
    private String title;
    private String author;
    private String summary;
    private BookISBN isbn;
    private String publisher;
    private LocalDate publicationDate;
    private CategoryId categoryId;
}
