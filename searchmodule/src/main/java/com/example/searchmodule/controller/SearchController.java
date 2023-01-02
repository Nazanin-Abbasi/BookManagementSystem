package com.example.searchmodule.controller;


import com.example.searchmodule.dto.response.BookArrayResponse;
import com.example.searchmodule.dto.response.BookResponse;
import com.example.searchmodule.service.interfaces.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/search")
public class SearchController {

    private RestTemplate rest;

    @Autowired
    public SearchController(RestTemplateBuilder builder) {
        rest = builder.build();
    }

    @Autowired
    private @Qualifier("RestAPISearchServiceImp")
    SearchService searchService;


    @GetMapping("/published_year")
    public BookArrayResponse showBasedOnPublishedYear(@RequestParam (name = "publishedYear") Integer publishedYear){
        BookArrayResponse bookArrayResponse = new BookArrayResponse();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(("http://localhost:9092/book/show_all"));

        ResponseEntity<BookArrayResponse> responseEntity = rest.exchange(uriComponentsBuilder.toUriString(),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                BookArrayResponse.class);

        List<BookResponse> bookResponses = responseEntity.getBody().getResponses();
        bookArrayResponse.setResponses(bookResponses);
        BookArrayResponse response = searchService.findPublishedYear(bookArrayResponse, publishedYear);

        return response;
    }

    @GetMapping("/keywords")
    public BookArrayResponse showBasedOnKeywords( @RequestParam(name = "keyword") String keyword){
        BookArrayResponse bookArrayResponse = new BookArrayResponse();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(("http://localhost:9092/book/show_all"));

        ResponseEntity<BookArrayResponse> responseEntity = rest.exchange(uriComponentsBuilder.toUriString(),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                BookArrayResponse.class);

        List<BookResponse> bookResponses = responseEntity.getBody().getResponses();
        bookArrayResponse.setResponses(bookResponses);
        BookArrayResponse response = searchService.findKeyword(bookArrayResponse, keyword);

        return response;
    }

    @GetMapping("/filter")
    public BookArrayResponse filter(@RequestParam (name = "writer") String writer,
                                    @RequestParam (name = "publisher") String publisher,
                                    @RequestParam (name = "published_year") Integer publishedYear){

        BookArrayResponse bookArrayResponse = new BookArrayResponse();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(("http://localhost:9092/book/show_all"));

        ResponseEntity<BookArrayResponse> responseEntity = rest.exchange(uriComponentsBuilder.toUriString(),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                BookArrayResponse.class);

        List<BookResponse> bookResponses = responseEntity.getBody().getResponses();
        bookArrayResponse.setResponses(bookResponses);
        BookArrayResponse response = searchService.filter(bookArrayResponse, writer, publisher, publishedYear);

        return response;
    }
}
