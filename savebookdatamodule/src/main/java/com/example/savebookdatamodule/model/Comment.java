package com.example.savebookdatamodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
    private String content;
    private String username;
    private Integer internationalSerialBookNo;

}
