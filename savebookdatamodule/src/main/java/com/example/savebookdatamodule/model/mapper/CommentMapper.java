package com.example.savebookdatamodule.model.mapper;

import com.example.savebookdatamodule.dto.request.CommentRequest;
import com.example.savebookdatamodule.dto.response.BookArrayResponse;
import com.example.savebookdatamodule.dto.response.BookResponse;
import com.example.savebookdatamodule.dto.response.CommentArrayResponse;
import com.example.savebookdatamodule.dto.response.CommentResponse;
import com.example.savebookdatamodule.model.Book;
import com.example.savebookdatamodule.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentMapper {

    public static Comment toComment(CommentRequest commentRequest){
        return new Comment(commentRequest.getContent(),
                commentRequest.getUsername(),
                commentRequest.getInternationalSerialBookNo());

    }

    public static CommentArrayResponse convertToCommentList(List<Comment> comments){
        CommentArrayResponse commentArrayResponse = new CommentArrayResponse();
        List<CommentResponse> commentResponses = new ArrayList<>();

        for (Comment comment: comments)
            commentResponses.add(toCommentResponse(comment));

        commentArrayResponse.setCommentResponses(commentResponses);
        return commentArrayResponse;
    }

    public static CommentResponse toCommentResponse(Comment comment){
        return new CommentResponse(comment.getContent(),
                comment.getUsername(),
                comment.getInternationalSerialBookNo());
    }

    public static List<Comment> toCommentList(CommentArrayResponse commentArrayResponse){
        List<Comment> comments = new ArrayList<>();

        for (int i=0; i<commentArrayResponse.getCommentResponses().size(); i++)
            comments.add(convertToComment(commentArrayResponse.getCommentResponses().get(i)));

        return comments;
    }

    public static Comment convertToComment(CommentResponse commentResponse){
        return new Comment(commentResponse.getContent(),
                commentResponse.getUsername(),
                commentResponse.getInternationalSerialBookNo());
    }
}

