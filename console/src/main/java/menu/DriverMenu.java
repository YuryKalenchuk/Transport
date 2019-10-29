package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverMenu implements Menu {
    @Override
    public void printTextMenu() {
        System.out.println("1-Get Station Inteneary");
        System.out.println("2-Get Route");
        System.out.println("3-Edit profile");
        System.out.println("4-Associate with Transport");
        System.out.println("5-Get Feedback");
        System.out.println("6-Problem report");
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
                        //UserService.getAllNews().forEach(Output::printNews);
                        break;
                    case 2:
                        //  UserService.registration(Input.inputClient());
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
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
