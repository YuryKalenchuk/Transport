package dao.utils;

import entity.Role;
import entity.User;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoginUtils {
    public static User loginUser() {
        boolean flag = true;
        User rUser =null;
        Role role = null;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            FileSaveUtils fs = new FileSaveUtils();
            User loginUser = new User();
            List<User> list;
            System.out.println("Enter Your Login or Enter 0 to Exit");
            String login = scanner.next();
            loginUser.setLogin(login);
            if (login.equals("0")){
                return null;
            }
            System.out.println("Enter Your Password");
            String password = scanner.next();
            loginUser.setPassword(password);
            list = fs.readUsers();
            list = list.stream()
                    .filter(user -> user.getLogin().equals(loginUser.getLogin()))
                    .collect(Collectors.toList());
            if (list.size() != 0 && list.get(0).getPassword().equals(loginUser.getPassword())) {
                System.out.println("Welcome " + list.get(0).getName());
                rUser = list.get(0);
                flag = false;
            } else {
                System.out.println("Wrong name or password ");
            }
        }
        return rUser;
    }
}
