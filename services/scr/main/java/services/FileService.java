package services;

import com.google.gson.Gson;
import entity.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileService {
    public void writeUsers(List<User> users) {
        Gson gson = new Gson();
        FileWriter fw = null;
        try {
            fw = new FileWriter("usersDb.txt");

            User[] userInfo = new User[users.size()];
            users.toArray(userInfo);
            String line = gson.toJson(userInfo, User[].class);
            fw.write(line);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> readUsers() {
        String userInfoJson = null;
        List<User> list = new ArrayList<>();
        User[] userInfo;
        Gson gson = new Gson();
        try {
            userInfoJson = new String(Files.readAllBytes(Paths.get("usersDb.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        userInfo = gson.fromJson(userInfoJson, User[].class);
        list.addAll(Arrays.asList(userInfo));
        return list;
    }
}





