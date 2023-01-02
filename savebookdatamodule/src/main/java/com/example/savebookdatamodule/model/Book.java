package com.example.savebookdatamodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private Integer internationalSerialBookNo;
    private String title;
    private List<String> writers;
    private String publisher;
    private Integer publishedYear;
    private String insertTime;
    //private byte[] image;
    private List<String> keywords;

}
