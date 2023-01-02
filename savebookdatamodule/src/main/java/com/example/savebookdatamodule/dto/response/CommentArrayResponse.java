package com.example.savebookdatamodule.dto.response;

import lombok.Data;

import java.util.List;


@Data
public class CommentArrayResponse {
    private List<CommentResponse> commentResponses;
}
