package com.example.savebookdatamodule.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class BookArrayResponse {
    private List<BookResponse> responses;
}
