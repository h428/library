package com.hao.library.ddd.types.book;

import java.io.Serializable;
import java.time.LocalDate;

public record BookPublicationDate(LocalDate value) implements Serializable {

}
