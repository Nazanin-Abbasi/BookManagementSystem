package com.example.savebookdatamodule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private String content;
    private String username;
    private Integer internationalSerialBookNo;
}
