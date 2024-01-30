package code;
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
            "   2. SEARCH COLLECTIONS\n" +
            "   3. EXTEND LOAN PERIOD\n" +
            "   99. BACK\n" +
            "   00. EXIT\n" +
            "INPUT MENU -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();

        if (userInputMenu == 1) {
            borrowBooksMenu();
        } else if (userInputMenu == 2) {
            searchCollectionsMenu();
        } else if (userInputMenu == 3) {
            extendLoanPeriod();
        } else if (userInputMenu == 99) {
            main.login();
        } else if (userInputMenu == 00) {
            main.exit();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void borrowBooksMenu() {
        main.clearScreen();

        System.out.println(
            "-- BORROW BOOKS MENU --"
        );
    }

    private static void searchCollectionsMenu() {
        main.clearScreen();

        System.out.println(
            "-- SEARCH LIBRARY COLLECTIONS MENU --"
        );
    }

    private static void extendLoanPeriod() {
        main.clearScreen();

        System.out.println(
            "-- EXTEND LOAN PERIOD MENU --"
        );
    }
}
