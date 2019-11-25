package dao.interfaces;

import entity.User;

import java.util.List;

public interface UserCRUT {
    List<User> getAllUsers();
    boolean deleteUserByLogin(String login);
    boolean editProfile(User user);
    String addNewUser();
}
