package menu;


import entity.Role;

public class FabricMethod {

    private Menu menu;

    public Menu getMenu(Role role) {
        switch (role) {
            case USER:
                menu = new UserMenu();
                break;
            case ADMIN:
                menu = new AdminMenu();
                break;
            case DRIVER:
                menu = new DriverMenu();
                break;
            default:
                System.out.println("Sorry. Unknown role");
                break;
        }
        return menu;
    }
}
