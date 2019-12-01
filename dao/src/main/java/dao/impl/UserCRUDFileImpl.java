package dao.impl;

import dao.interfaces.UserCRUD;
import dao.utils.FileUtils;
import entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserCRUDFileImpl implements UserCRUD {

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


    public boolean editProfile(User userApp) {
        FileUtils fu = new FileUtils();
        List<User> list = fu.readUsers();
        User userDb = new User();
        userDb = list.stream().filter(station -> station.getId().equals(userApp.getId())).collect(Collectors.toList()).get(0);
        if (userDb == null) {
            System.out.println("Wrong User ID");
            return false;
        } else {
            list.removeIf(user -> user.getId().equals(userApp.getId()));
            list.add(userApp);
            fu.writeUsers(list);
            return true;
        }
    }

    public boolean addNewUser(User userApp) {
        FileUtils fu = new FileUtils();
        List<User> list = fu.readUsers();
        if (list.stream().filter(user -> user.getId().equals(userApp.getId())).collect(Collectors.toList()).size() > 0) {
            return false;
        } else {
            list.add(userApp);
            fu.writeUsers(list);
            return true;
        }
    }

}
