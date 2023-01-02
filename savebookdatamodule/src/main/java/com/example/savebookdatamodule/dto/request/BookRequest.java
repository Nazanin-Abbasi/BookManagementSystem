package com.example.savebookdatamodule.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    private Integer internationalSerialBookNo;
    private String title;
    private List<String> writers;
    private String publisher;
    private Integer publishedYear;
    private List<String> keywords;

}
