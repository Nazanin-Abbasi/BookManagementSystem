package com.example.searchmodule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private Integer internationalSerialBookNo;
    private String title;
    private List<String> writers;
    private String publisher;
    private Integer publishedYear;
    private String insertTime;
    //private byte[] image;
    private List<String> keywords;
}
