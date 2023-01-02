package com.example.savebookdatamodule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRemoveRequest {
    private String username;
    private Integer internationalSerialBookNo;
}
