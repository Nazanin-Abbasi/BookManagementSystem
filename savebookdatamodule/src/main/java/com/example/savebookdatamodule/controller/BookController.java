package com.example.savebookdatamodule.controller;


import com.example.savebookdatamodule.dto.request.BookISSNRequest;
import com.example.savebookdatamodule.dto.request.BookRequest;
import com.example.savebookdatamodule.dto.response.BookArrayResponse;
import com.example.savebookdatamodule.dto.response.BookResponse;
import com.example.savebookdatamodule.dto.response.DefaultResponse;
import com.example.savebookdatamodule.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    private @Qualifier("FileBasedBookServiceImp")
    BookService bookService;


    @PostMapping("/add")
    public DefaultResponse addBook(@RequestBody BookRequest bookRequest,
                                   @RequestParam (name = "username") String username){

        if(username.equals("Admin") || username.equals("publisher")){
            DefaultResponse response = bookService.addBook(bookRequest);
            return response;
        }
        return null;
    }

    @PostMapping("/remove")
    public BookResponse removeBook(@RequestBody BookISSNRequest bookISSNRequest,
                                   @RequestParam (name = "username") String username){

        if(username.equals("Admin") || username.equals("publisher")){
            BookResponse book = bookService.removeBook(bookISSNRequest);
            return book;
        }

        return null;
    }

    @PostMapping("/edit")
    public BookResponse editBook(@RequestBody BookRequest bookRequest,
                                 @RequestParam (name = "username") String username){

        if(username.equals("Admin") || username.equals("publisher")){
            BookResponse book = bookService.editBook(bookRequest);
            return book;
        }

        return null;

    }

    @GetMapping("/show_all")
    public BookArrayResponse showAll(){
        BookArrayResponse response = bookService.getAllBooks();
        return response;
    }
}
