package com.example.savebookdatamodule.service.interfaces;

import com.example.savebookdatamodule.dto.request.CommentRemoveRequest;
import com.example.savebookdatamodule.dto.request.CommentRequest;
import com.example.savebookdatamodule.dto.response.CommentArrayResponse;
import com.example.savebookdatamodule.dto.response.CommentResponse;
import com.example.savebookdatamodule.dto.response.DefaultResponse;
import org.springframework.stereotype.Service;


@Service
public interface CommentService {

    public DefaultResponse addComment(CommentRequest commentRequest);
    public CommentResponse removeComment(CommentRemoveRequest commentRemoveRequest);
    public CommentResponse editComment(CommentRequest commentRequest);
    public CommentArrayResponse getAllComments();
}
