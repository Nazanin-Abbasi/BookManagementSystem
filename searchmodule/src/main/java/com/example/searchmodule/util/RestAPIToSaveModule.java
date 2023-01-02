package com.example.searchmodule.util;

import com.example.searchmodule.dto.response.BookArrayResponse;
import com.example.searchmodule.dto.response.BookResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.concurrent.Exchanger;

@NoArgsConstructor
public class RestAPIToSaveModule {

    private RestTemplate rest;

    @Autowired
    public RestAPIToSaveModule(RestTemplateBuilder builder) {
        rest = builder.build();
    }

    public BookArrayResponse connectToSaveModule(){
        BookArrayResponse bookArrayResponse = new BookArrayResponse();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(("http://localhost:9092/book/show_all"));

        ResponseEntity<BookArrayResponse> responseEntity = rest.exchange(uriComponentsBuilder.toUriString(),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                BookArrayResponse.class);

        List<BookResponse> bookResponses = responseEntity.getBody().getResponses();
        bookArrayResponse.setResponses(bookResponses);

        return bookArrayResponse;
    }
}
