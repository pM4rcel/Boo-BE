package com.example.booo.BookAuthors;

import com.example.booo.Repository;

import java.util.List;

public class BookAuthorsRepository implements Repository<BookAuthorsEntity, Long> {

    @Override
    public BookAuthorsEntity findByID(Long aLong) {
        return null;
    }

    @Override
    public List<BookAuthorsEntity> findAll() {
        return null;
    }

    @Override
    public void deleteByID(Long aLong) {

    }
}
