package menu;

import entity.Role;
import dao.services.LoginServise;
import dao.services.RegService;
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
                        User user = LoginServise.loginUser();
                        role = user.getRole();
                        if (role != null) {
                            FabricMethod fabricMethod = new FabricMethod();
                            Menu menu = fabricMethod.getMenu(role);
                            menu.printMenu();
                        }
                        break;
                    case 2:
                        RegService.inputUser();
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
