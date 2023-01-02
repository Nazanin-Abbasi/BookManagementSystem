package com.example.savebookdatamodule.service.implementations;


import com.example.savebookdatamodule.dto.request.BookISSNRequest;
import com.example.savebookdatamodule.dto.request.BookRequest;
import com.example.savebookdatamodule.dto.response.BookArrayResponse;
import com.example.savebookdatamodule.dto.response.BookResponse;
import com.example.savebookdatamodule.dto.response.DefaultResponse;
import com.example.savebookdatamodule.model.Book;
import com.example.savebookdatamodule.model.mapper.BookMapper;
import com.example.savebookdatamodule.repository.FileRepository;
import com.example.savebookdatamodule.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Qualifier("FileBasedBookServiceImp")
public class FileBasedBookService implements BookService {

    private FileRepository fileRepository;


    @Autowired
    public FileBasedBookService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Override
    public DefaultResponse addBook(BookRequest bookRequest) {
        boolean result = false;

        try {
            result = fileRepository.addBook(BookMapper.toBook(bookRequest));
        }catch (Exception exception){
            new DefaultResponse("Exception raised: " + exception.getMessage());
        }

        if(result)
            return new DefaultResponse("Book added successfully");
        return new DefaultResponse("Oops. Something went wrong");
    }

    @Override
    public BookResponse removeBook(BookISSNRequest bookISSNRequest) {
        BookArrayResponse bookArrayResponse = getAllBooks();
        BookResponse book = null;
        boolean result = false;

        for(int i=0; i< bookArrayResponse.getResponses().size(); i++){
            if(bookArrayResponse.getResponses().get(i).getInternationalSerialBookNo().equals(bookISSNRequest.getInternationalSerialBookNo())) {
                book = bookArrayResponse.getResponses().get(i);
                bookArrayResponse.getResponses().remove(i);
            }
        }

        try {
            result = fileRepository.writeAllBooks(BookMapper.convertToBookList(bookArrayResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result)
            return book;

        return null;


    }

    @Override
    public BookResponse editBook(BookRequest bookRequest) {
        BookArrayResponse bookArrayResponse = getAllBooks();
        BookResponse book = null;
        boolean result = false;

        for (int i=0; i<bookArrayResponse.getResponses().size(); i++){
            if(bookArrayResponse.getResponses().get(i).getInternationalSerialBookNo().equals(bookRequest.getInternationalSerialBookNo())){
                bookArrayResponse.getResponses().get(i).setTitle(bookRequest.getTitle());
                bookArrayResponse.getResponses().get(i).setWriters(bookRequest.getWriters());
                bookArrayResponse.getResponses().get(i).setPublisher(bookRequest.getPublisher());
                bookArrayResponse.getResponses().get(i).setPublishedYear(bookRequest.getPublishedYear());
                bookArrayResponse.getResponses().get(i).setKeywords(bookRequest.getKeywords());

                book = bookArrayResponse.getResponses().get(i);
            }
        }

        try {
            result = fileRepository.writeAllBooks(BookMapper.convertToBookList(bookArrayResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result)
            return book;

        return null;
    }

    @Override
    public BookArrayResponse getAllBooks() {
        try {
            List<Book> books = fileRepository.readAllBooks();
            return BookMapper.convertToBookArrayResponse(books);
        }catch (Exception exception){
            return new BookArrayResponse();
        }

    }
}
