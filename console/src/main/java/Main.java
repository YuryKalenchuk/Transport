import dbImpl.AdminDaoDbImpl;
import entity.User;

public class Main {
    public static void main(String[] args) {
       // MainMenu.go();
        AdminDaoDbImpl adb = new AdminDaoDbImpl();
        adb.getAllUsers().forEach(user -> System.out.println(user));
        User u2 = new User();
                u2.setName("Anatoly");
        u2.setId("1aa");
        System.out.println(adb.editProfile(u2));
    }
}
