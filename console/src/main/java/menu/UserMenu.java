package menu;

import impl.UserServiceImpl;
import interfaces.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenu implements Menu {
    private UserService userService = new UserServiceImpl();
    Scanner sc = new Scanner(System.in);

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
                switch (sc.next().trim()) {
                    case "1":
                        System.out.println("Enter Station name");
                        String str = sc.next();
                        System.out.println(userService.getStationInteneary(str));
                        break;
                    case "2":
                        String start;
                        String finish;
                        System.out.println("Enter Start Station");
                        start = sc.next();
                        while (start.isEmpty()) {
                            System.out.println("Enter Start Station");
                            start = sc.next();
                        }
                        System.out.println("Enter Finish Station");
                        finish=sc.next();
                        while (finish.isEmpty()) {
                            System.out.println("Enter Start Station");
                            finish = sc.next();
                        }
                        System.out.println(userService.getTransportToStation(start,finish));
                        break;
                    case "3":
                        break;
                    case "4":
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("Wrong input variant! Please, try again!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());

        }
    }
}