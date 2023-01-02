package com.example.savebookdatamodule.repository;

import com.example.savebookdatamodule.model.Book;
import com.example.savebookdatamodule.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@AllArgsConstructor
public class FileRepository {

    File bookFile;
    File commentFile;
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;

    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;

    @Autowired
    public FileRepository(){
        bookFile = new File("Books.txt");
        commentFile = new File("Comments.txt");
    }

    public boolean addBook(Book book) throws IOException {
        fileOutputStream = new FileOutputStream(bookFile, true);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(book);
        fileOutputStream.close();
        return true;
    }

    public List<Book> readAllBooks() throws IOException, ClassNotFoundException {
        fileInputStream = new FileInputStream(bookFile);
        List<Book> books = new ArrayList<>();
        objectInputStream = new ObjectInputStream(fileInputStream);


        try {
            while (true){
                Object object = objectInputStream.readObject();

                if(object == null)
                    break;
                books.add((Book) object);
            }
        }catch (EOFException eofException){
            System.out.println("end of line");
        }

        fileInputStream.close();

        return books;
    }

    public boolean writeAllBooks(List<Book> books) throws IOException {
        fileOutputStream = new FileOutputStream(bookFile, false);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for(Book book: books)
            objectOutputStream.writeObject(book);

        fileOutputStream.close();

        return true;
    }

    public boolean addComment(Comment comment) throws IOException {
        fileOutputStream = new FileOutputStream(commentFile, true);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(comment);
        fileOutputStream.close();
        return true;
    }

    public List<Comment> readAllComments() throws IOException, ClassNotFoundException {
        fileInputStream = new FileInputStream(commentFile);
        List<Comment> comments = new ArrayList<>();
        objectInputStream = new ObjectInputStream(fileInputStream);


        try {
            while (true){
                Object object = objectInputStream.readObject();

                if(object == null)
                    break;
                comments.add((Comment) object);
            }
        }catch (EOFException eofException){
            System.out.println("End of line");
            return comments;
        }

        fileInputStream.close();

        return comments;
    }

    public boolean writeAllComments(List<Comment> comments) throws IOException {
        fileOutputStream = new FileOutputStream(commentFile, false);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for(Comment comment: comments)
            objectOutputStream.writeObject(comment);

        fileOutputStream.close();

        return true;

    }
}
