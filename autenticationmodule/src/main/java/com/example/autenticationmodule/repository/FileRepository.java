package com.example.autenticationmodule.repository;

import com.example.autenticationmodule.dto.response.UserArrayResponse;
import com.example.autenticationmodule.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Component
public class FileRepository {

    File file;
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;

    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;

    @Autowired
    public FileRepository() throws IOException {
        file = new File("Users.txt");
    }

    public boolean addUser(User user) throws IOException {
        fileOutputStream = new FileOutputStream(file);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        fileOutputStream.close();
        return true;
    }

    public List<User> getAllUsers() throws IOException, ClassNotFoundException {
        fileInputStream = new FileInputStream(file);
        List<User> users = new ArrayList<>();
        objectInputStream = new ObjectInputStream(fileInputStream);

        try {
            while (true){
                Object object = objectInputStream.readObject();

                if(object == null)
                    break;
                users.add((User) object);
            }
        }catch (EOFException eofException){
            System.out.println("end of file");
        }

        fileInputStream.close();

        return users;

    }

    public boolean writeAllUsers(List<User> users) throws IOException {
        fileOutputStream = new FileOutputStream(file, false);
        objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for(User user: users)
            objectOutputStream.writeObject(user);

        fileOutputStream.close();

        return true;
    }
}
