package com.example.searchmodule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterRequest {

    private List<String> writers;
    private String publisher;
    private Integer publishedYear;
}
