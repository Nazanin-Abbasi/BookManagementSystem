package com.example.searchmodule.service.interfaces;

import com.example.searchmodule.dto.response.BookArrayResponse;
import org.springframework.stereotype.Service;


@Service
public interface SearchService {

    public BookArrayResponse findPublishedYear(BookArrayResponse bookArrayResponse, Integer publishedYear);

    public BookArrayResponse findKeyword(BookArrayResponse bookArrayResponse, String keyword);

    public BookArrayResponse filter(BookArrayResponse bookArrayResponse, String writer, String publisher, Integer publishedYear);
}
