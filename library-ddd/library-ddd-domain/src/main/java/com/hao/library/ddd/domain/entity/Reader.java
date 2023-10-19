package com.hao.library.ddd.domain.entity;

import com.hao.library.ddd.types.common.CreateTime;
import com.hao.library.ddd.types.common.Phone;
import com.hao.library.ddd.types.common.UpdateTime;
import com.hao.library.ddd.types.reader.ReaderEmail;
import com.hao.library.ddd.types.reader.ReaderId;
import com.hao.library.ddd.types.reader.ReaderPassword;
import lombok.Getter;

@Getter
public class Reader {
    private ReaderId readerId;
    private String number;
    private ReaderPassword password;
    private String name;
    private Integer maxBorrowNum;
    private Integer maxBorrowDate;
    private ReaderEmail email;
    private Phone phone;
    private CreateTime createTime;
    private UpdateTime updateTime;

    public Reader(ReaderId readerId, String number, ReaderPassword password, String name, Integer maxBorrowNum,
        Integer maxBorrowDate, ReaderEmail email, Phone phone, CreateTime createTime, UpdateTime updateTime) {
        this.readerId = readerId;
        this.number = number;
        this.password = password;
        this.name = name;
        this.maxBorrowNum = maxBorrowNum;
        this.maxBorrowDate = maxBorrowDate;
        this.email = email;
        this.phone = phone;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }



}
