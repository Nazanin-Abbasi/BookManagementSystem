package com.example.searchmodule.service.implementations;

import com.example.searchmodule.dto.response.BookArrayResponse;
import com.example.searchmodule.dto.response.BookResponse;
import com.example.searchmodule.service.interfaces.SearchService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Qualifier("RestAPISearchServiceImp")
public class RestAPISearchService implements SearchService {


    @Override
    public BookArrayResponse findPublishedYear(BookArrayResponse bookArrayResponse, Integer publishedYear) {
        BookArrayResponse response = new BookArrayResponse();
        List<BookResponse> bookResponses = new ArrayList<>();
        for(int i=0; i<bookArrayResponse.getResponses().size(); i++){
            if(bookArrayResponse.getResponses().get(i).getPublishedYear().equals(publishedYear))
                bookResponses.add(bookArrayResponse.getResponses().get(i));
        }

        response.setResponses(bookResponses);

        return response;
    }

    @Override
    public BookArrayResponse findKeyword(BookArrayResponse bookArrayResponse, String keyword) {
        BookArrayResponse response = new BookArrayResponse();
        List<BookResponse> bookResponses = new ArrayList<>();

        for (int i=0; i<bookArrayResponse.getResponses().size(); i++){
            for(int j=0; j<bookArrayResponse.getResponses().get(i).getKeywords().size(); j++){
                if(bookArrayResponse.getResponses().get(i).getKeywords().get(j).equals(keyword))
                    bookResponses.add(bookArrayResponse.getResponses().get(i));

            }
        }

        response.setResponses(bookResponses);

        return response;
    }

    @Override
    public BookArrayResponse filter(BookArrayResponse bookArrayResponse, String writer, String publisher, Integer publishedYear) {
        BookArrayResponse response = new BookArrayResponse();
        List<BookResponse> bookResponses = new ArrayList<>();

        for(int i=0; i<bookArrayResponse.getResponses().size(); i++){
            if(bookArrayResponse.getResponses().get(i).getPublishedYear().equals(publishedYear)){
                if(bookArrayResponse.getResponses().get(i).getPublisher().equals(publisher)){
                    for(int j=0; j<bookArrayResponse.getResponses().get(i).getWriters().size(); j++){
                        if(bookArrayResponse.getResponses().get(i).getWriters().get(j).equals(writer))
                            bookResponses.add(bookArrayResponse.getResponses().get(i));

                    }
                }
            }
        }

        response.setResponses(bookResponses);

        return response;
    }
}
