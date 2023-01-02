package com.example.searchmodule.model.mapper;

import com.example.searchmodule.dto.response.BookArrayResponse;
import com.example.searchmodule.dto.response.BookResponse;
import com.example.searchmodule.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public static BookArrayResponse convertToBookArrayResponse(List<Book> books){
        BookArrayResponse bookArrayResponse = new BookArrayResponse();
        List<BookResponse> bookResponses = new ArrayList<>();

        for (Book book: books)
            bookResponses.add(toBookResponse(book));

        bookArrayResponse.setResponses(bookResponses);
        return bookArrayResponse;
    }

    public static BookResponse toBookResponse(Book book){

        return new BookResponse(book.getInternationalSerialBookNo(),
                book.getTitle(),
                book.getWriters(),
                book.getPublisher(),
                book.getPublishedYear(),
                book.getInsertTime(),
                book.getKeywords());
    }

}
