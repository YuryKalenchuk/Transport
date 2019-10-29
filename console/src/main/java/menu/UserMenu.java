package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu implements Menu {
    // private UserService userService = new UserServiceImpl();
    @Override
    public void printTextMenu() {
        System.out.println("1-Get Station Inteneary");
        System.out.println("2-Get Route");
        System.out.println("3-Edit profile");
        System.out.println("4-Send Feedback");
        System.out.println("0-Back to main menu");
        System.out.println("Input your variant: \n");
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