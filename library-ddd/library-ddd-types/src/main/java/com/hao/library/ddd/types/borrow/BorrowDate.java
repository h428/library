package com.hao.library.ddd.types.borrow;

import java.io.Serializable;
import java.time.LocalDate;

public record BorrowDate(LocalDate value) implements Serializable {

}
