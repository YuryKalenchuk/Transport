package menu;

import entity.Role;
import utils.LoginServise;
import utils.RegService;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainMenu {
    public static void printMenu() {
        System.out.println("1 - Login");
        System.out.println("2 - Registration ");
        System.out.println("0 - Exit");
        System.out.println("\nInput your variant: ");
    }

    public static void go() {
        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            Role role = null;
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        role = LoginServise.loginUser();
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
