package dao.services;
import entity.User;
import entity.Role;
import java.util.*;
import java.util.stream.Collectors;

public class RegService {


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
        String email = scanner.nextLine();
        user.setEmail(email);
        print("Input your login:");
        String login = scanner.nextLine();
        user.setLogin(login);
        print("Input your password:");
        String password = scanner.nextLine();
        user.setPassword(password);
        user.setRole(Role.USER);
        user.setId(UUID.randomUUID().toString());
        FileService fs = new FileService();
        list = fs.readUsers();
        while (list.stream().filter(u -> u.getId().equals(user.getId())).collect(Collectors.toList()).size() > 0) {
            user.setId(UUID.randomUUID().toString());
        }
        list.add(user);
        fs.writeUsers(list);
    }
}

