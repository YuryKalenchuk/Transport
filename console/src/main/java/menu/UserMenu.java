package menu;

import dao.impl.UserCRUDFileImpl;
import dao.utils.ValidateEmail;
import entity.User;
import impl.UserServiceImpl;
import interfaces.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserMenu implements Menu {
    private UserService userService = new UserServiceImpl();


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
                        User user = new UserCRUDFileImpl().getAllUsers().stream().filter(user1 -> user1.getId().equalsIgnoreCase(MainMenu.sessionId)).collect(Collectors.toList()).get(0);
                        User newUser = new User();
                        Pattern patternName = Pattern.compile("[a-zA-Z0-9]{3}");
                        System.out.println("Enter new name alfabet and numbers only, 3 char minimum");
                        String newName = sc.next();
                        Matcher matcher ;
                        while (patternName.matcher(newName).matches()){
                            newName = sc.next();
                        }
                        System.out.println("Enter new email");
                        String newEmail = sc.next();
                        ValidateEmail valid =new ValidateEmail();
                        while (!valid.validate(newEmail)){
                            System.out.println("Wrong Email format, try again! ");
                            newEmail=sc.next();
                        }
                        System.out.println("Enter new password (6+ char)");
                        String newPsw =sc.next();
                        while(newPsw.length()<6){
                            newPsw=sc.next();
                        }
                        newUser.setName(newName);
                        newUser.setPassword(newPsw);
                        newUser.setEmail(newEmail);
                        newUser.setId(user.getId());
                        newUser.setLogin(user.getLogin());
                        UserServiceImpl usi = new UserServiceImpl();
                       if( usi.editProfile(newUser)){
                           System.out.println("Success");
                       }
                       else {
                           System.out.println("Error");
                       }
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