import java.util.Scanner;

public class patron {
    static Scanner scan1 = main.scan1;
    static int userInputMenu = main.userInputMenu;

    //------------------- MAIN MENU -------------------//
    public static void patronsMenu() {
        main.clearScreen();
        System.out.print(
            "-- PATRON MENU --\n" +
            "   1. BORROW BOOKS\n" +
            "   2. SEARCH BOOKS\n" +
            "   3. EXTEND LOAN PERIOD\n" +
            "   99. BACK\n" +
            "   00. EXIT\n" +
            "INPUT MENU -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();
    }
}
