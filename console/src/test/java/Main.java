import menu.FabricMethod;
import menu.Menu;
import entity.Role;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static void printMainMenu() {
        System.out.println("1-Enter like User ");
        System.out.println("2-Enter like Driver ");
        System.out.println("3-Enter like Admin ");
        System.out.println("0-Exit");
    }

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input number of variant: ");
            try {
                Role role = null;
                switch (scanner.nextInt()) {
                    case 1:
                        role = Role.USER;
                        break;
                    case 2:
                        role = Role.DRIVER;
                        break;
                    case 3:
                        role = Role.ADMIN;
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        throw new InputMismatchException("Wrong input variant! Please, try again!");
                }
                FabricMethod fabricMethod = new FabricMethod();
                Menu menu = fabricMethod.getMenu(role);
                menu.printMenu();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

