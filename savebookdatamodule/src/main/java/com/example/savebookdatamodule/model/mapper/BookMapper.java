package com.example.savebookdatamodule.model.mapper;


import com.example.savebookdatamodule.dto.request.BookRequest;
import com.example.savebookdatamodule.dto.response.BookArrayResponse;
import com.example.savebookdatamodule.dto.response.BookResponse;
import com.example.savebookdatamodule.model.Book;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public static Book toBook(BookRequest bookRequest){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String insertTime= dtf.format(now);

        return new Book(bookRequest.getInternationalSerialBookNo(),
                bookRequest.getTitle(),
                bookRequest.getWriters(),
                bookRequest.getPublisher(),
                bookRequest.getPublishedYear(),
                insertTime,
                bookRequest.getKeywords());

    }

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

    public static List<Book> convertToBookList(BookArrayResponse bookArrayResponse){
        List<Book> books = new ArrayList<>();

        for (int i=0; i<bookArrayResponse.getResponses().size(); i++)
            books.add(convertToBook(bookArrayResponse.getResponses().get(i)));

        return books;
    }

    public static Book convertToBook(BookResponse bookResponse){
        return new Book(bookResponse.getInternationalSerialBookNo(),
                bookResponse.getTitle(),
                bookResponse.getWriters(),
                bookResponse.getPublisher(),
                bookResponse.getPublishedYear(),
                bookResponse.getInsertTime(),
                bookResponse.getKeywords());

    }
}
