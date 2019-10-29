package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu implements Menu {
    // private UserService userService = new UserServiceImpl();
    @Override
    public void printTextMenu() {
        System.out.println("1-Create User");
        System.out.println("2-Get User Info");
        System.out.println("3-Delete User");
        System.out.println("4-Edit User");
        System.out.println("5-Create Transport");
        System.out.println("6-Delete Transport");
        System.out.println("7-Edit Transport");
        System.out.println("0-Back to main menu");
        System.out.println("\nInput your variant: ");
    }

    @Override
    public void printMenu() {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        try {
            while (flag) {
                printTextMenu();
                switch (sc.nextInt()) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        throw new InputMismatchException("Wrong input variant! Please, try again!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
