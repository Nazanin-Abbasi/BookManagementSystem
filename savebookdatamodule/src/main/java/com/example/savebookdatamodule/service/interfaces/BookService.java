package com.example.savebookdatamodule.service.interfaces;

import com.example.savebookdatamodule.dto.request.BookISSNRequest;
import com.example.savebookdatamodule.dto.request.BookRequest;
import com.example.savebookdatamodule.dto.response.BookArrayResponse;
import com.example.savebookdatamodule.dto.response.BookResponse;
import com.example.savebookdatamodule.dto.response.DefaultResponse;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BookService {

    public DefaultResponse addBook(BookRequest bookRequest);
    public BookResponse removeBook(BookISSNRequest bookISSNRequest);
    public BookResponse editBook(BookRequest bookRequest);
    public BookArrayResponse getAllBooks();

}
