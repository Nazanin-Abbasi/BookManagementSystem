package com.example.savebookdatamodule.service.implementations;

import com.example.savebookdatamodule.dto.request.CommentRemoveRequest;
import com.example.savebookdatamodule.dto.request.CommentRequest;
import com.example.savebookdatamodule.dto.response.CommentArrayResponse;
import com.example.savebookdatamodule.dto.response.CommentResponse;
import com.example.savebookdatamodule.dto.response.DefaultResponse;
import com.example.savebookdatamodule.model.Comment;
import com.example.savebookdatamodule.model.mapper.CommentMapper;
import com.example.savebookdatamodule.repository.FileRepository;
import com.example.savebookdatamodule.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
@Qualifier("FileBasedCommentServiceImp")
public class FileBasedCommentService implements CommentService {

    private FileRepository fileRepository;


    @Autowired
    public FileBasedCommentService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public DefaultResponse addComment(CommentRequest commentRequest) {
        boolean result = false;

        try {
            result = fileRepository.addComment(CommentMapper.toComment(commentRequest));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result)
            return new DefaultResponse("Comment added successfully ");
        return new DefaultResponse("Oops. Something went wrong");
    }

    @Override
    public CommentResponse removeComment(CommentRemoveRequest commentRemoveRequest) {
        CommentArrayResponse commentArrayResponse = getAllComments();
        CommentResponse commentResponse = null;
        boolean result = false;

        for (int i=0; i<commentArrayResponse.getCommentResponses().size(); i++){
            if(commentArrayResponse.getCommentResponses().get(i).getInternationalSerialBookNo()
                    .equals(commentRemoveRequest.getInternationalSerialBookNo())){
                if(commentArrayResponse.getCommentResponses().get(i).getUsername()
                        .equals(commentRemoveRequest.getUsername())){
                    commentResponse = commentArrayResponse.getCommentResponses().get(i);
                    commentArrayResponse.getCommentResponses().remove(i);
                }
            }
        }

        try {
            result = fileRepository.writeAllComments(CommentMapper.toCommentList(commentArrayResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result)
            return commentResponse;

        return null;
    }

    @Override
    public CommentResponse editComment(CommentRequest commentRequest) {
        CommentArrayResponse commentArrayResponse = getAllComments();
        CommentResponse response = null;
        boolean result = false;

        for(int i=0; i<commentArrayResponse.getCommentResponses().size(); i++){
            if(commentArrayResponse.getCommentResponses().get(i).getInternationalSerialBookNo().equals(commentRequest.getInternationalSerialBookNo())){
                String username1 = commentArrayResponse.getCommentResponses().get(i).getUsername();
                String username2 = commentRequest.getUsername();

                if(username1.equals(username2)){
                    commentArrayResponse.getCommentResponses().get(i).setContent(commentRequest.getContent());
                    response = commentArrayResponse.getCommentResponses().get(i);
                }
            }
        }

        try {
            result = fileRepository.writeAllComments(CommentMapper.toCommentList(commentArrayResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result)
            return response;

        return null;
    }

    @Override
    public CommentArrayResponse getAllComments() {
        try {
            List<Comment> comments = fileRepository.readAllComments();
            return CommentMapper.convertToCommentList(comments);
        } catch (Exception exception){
            return new CommentArrayResponse();
        }
    }
}
