package com.example.savebookdatamodule.controller;


import com.example.savebookdatamodule.dto.request.CommentRemoveRequest;
import com.example.savebookdatamodule.dto.request.CommentRequest;
import com.example.savebookdatamodule.dto.response.CommentArrayResponse;
import com.example.savebookdatamodule.dto.response.CommentResponse;
import com.example.savebookdatamodule.dto.response.DefaultResponse;
import com.example.savebookdatamodule.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {


    @Autowired
    private @Qualifier("FileBasedCommentServiceImp")
    CommentService commentService;

    @PostMapping("/add")
    public DefaultResponse addComment(@RequestBody CommentRequest commentRequest){
        DefaultResponse response = commentService.addComment(commentRequest);
        return response;
    }

    @PostMapping("/remove")
    public CommentResponse removeComment(@RequestBody CommentRemoveRequest commentRemoveRequest){
        CommentResponse commentResponse = commentService.removeComment(commentRemoveRequest);
        return commentResponse;
    }

    @PostMapping("/edit")
    public CommentResponse editComment(@RequestBody CommentRequest commentRequest){
        CommentResponse response = commentService.editComment(commentRequest);
        return response;
    }

    @GetMapping("/show_all")
    public CommentArrayResponse showAllComments(){
        CommentArrayResponse response = commentService.getAllComments();
        return response;
    }


}
