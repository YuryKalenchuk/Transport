package dao.utils;

import dao.utils.FileSaveUtils;
import entity.User;
import entity.Role;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegUtils {


    private static void print(String message) {
        System.out.print("\n" + message);
    }

    public static void inputUser() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        List<User> list;
        print("Input your name: ");
        String name = scanner.nextLine();
        user.setName(name);
        print("Input your email: ");
        ValidateEmail valid = new ValidateEmail();
        String email;
        email = scanner.nextLine();
        while (!valid.validate(email)){
            System.out.println("Wrong email!!! Try Again ");
            email = scanner.nextLine();
        }
        user.setEmail(email);
        print("Input your login:");
        String login = scanner.nextLine();
        user.setLogin(login);
        print("Input your password:");
        String password = scanner.nextLine();
        user.setPassword(password);
        user.setRole(Role.USER);
        user.setId(UUID.randomUUID().toString());
        FileSaveUtils fs = new FileSaveUtils();
        list = fs.readUsers();
        while (list.stream().filter(u -> u.getId().equals(user.getId())).collect(Collectors.toList()).size() > 0) {
            user.setId(UUID.randomUUID().toString());
        }
        list.add(user);
        fs.writeUsers(list);
    }
}

