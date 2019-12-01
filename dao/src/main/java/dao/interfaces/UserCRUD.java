package dao.interfaces;

import entity.User;

import java.util.List;

public interface UserCRUD {
    List<User> getAllUsers();
    boolean deleteUserByLogin(String login);
    boolean editProfile(User user);
    boolean addNewUser(User user);
}
