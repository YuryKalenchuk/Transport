package menu;

import entity.Role;
import dao.utils.LoginUtils;
import dao.utils.RegUtils;
import entity.User;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainMenu {
    public static void printMenu() {
        System.out.println("1 - Login");
        System.out.println("2 - Registration ");
        System.out.println("0 - Exit");
        System.out.println("\nEnter your choise: ");
    }

    public static void go() {
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            Role role;
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        User user = LoginUtils.loginUser();
                        if (user != null){
                            role = user.getRole();
                        }
                        else {role = null;}
                            if (role != null) {
                            FabricMethod fabricMethod = new FabricMethod();
                            Menu menu = fabricMethod.getMenu(role);
                            menu.printMenu();
                        }
                        break;
                    case 2:
                        RegUtils.inputUser();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        throw new InputMismatchException("Wrong input variant! Please, try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
