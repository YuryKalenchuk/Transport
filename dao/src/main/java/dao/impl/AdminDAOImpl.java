package dao.impl;

import dao.interfaces.UserCRUT;
import dao.utils.FileUtils;
import entity.User;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdminDAOImpl implements UserCRUT {

    public List<User> getAllUsers() {

        FileUtils fs = new FileUtils();
        List<User> list;
        list = fs.readUsers();
        return list;
    }

    public boolean deleteUserByLogin(String login) {
        FileUtils fs = new FileUtils();
        List<User> list;
        list = fs.readUsers();
        list = list.stream()
                .filter(user -> !user.getLogin().equals(login))
                .collect(Collectors.toList());
        fs.writeUsers(list);
        return false;
    }


    public boolean editProfile(User user) {
        Scanner sc = new Scanner(System.in);


        return false;
    }

    public String addNewUser() {

        return null;
    }

}
