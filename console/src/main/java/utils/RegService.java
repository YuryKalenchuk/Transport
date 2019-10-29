package utils;

import entity.User;
import entity.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegService {


    private static void print(String message) {
        System.out.print("\n" + message);
    }

    public static void inputUser() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        List<User> list = new ArrayList<>();
        print("Input your name: ");
        String name = scanner.nextLine();
        user.setName(name);
        print("Input your email: ");
        String email = scanner.nextLine();
        user.setEmail(email);
        print("Input your login:");
        String login = scanner.nextLine();
        user.setLogin(login);
        print("Input your password:");
        String password = scanner.nextLine();
        user.setPassword(password);
        user.setRole(Role.USER);
        FileService fs = new FileService();
        list = fs.readUsers();
        list.add(user);
        fs.writeUsers(list);
    }
}

