package code;
import java.util.Scanner;

public class admin {
    static Scanner scan1 = main.scan1;
    static int userInputMenu = main.userInputMenu;

    public static void adminsMenu() {
        main.clearScreen();

        System.out.print(
            "-- ADMIN MENU --\n" +
            "   1. LIBRARIAN SETTINGS\n"+
            "   2. CHECK SYSTEM\n" +
            "   99. BACK\n" +
            "   00. EXIT\n" +
            "INPUT MENU -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();
    }
}