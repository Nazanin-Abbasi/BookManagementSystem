package com.example.savebookdatamodule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private String content;
    private String username;
    private Integer internationalSerialBookNo;
}
