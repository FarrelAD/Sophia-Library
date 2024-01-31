package code;
import java.util.ArrayList;
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

        System.out.print(
            "BORROW BOOK HERE!\n" +
            " (Type <99> for back)\n" +
            "=====================================\n" +
            " - BOOK AMOUNT (MAX 3)     : "
        );
        int bookAmount = scan1.nextInt();
        scan1.nextLine();

        if (bookAmount > 3 && bookAmount != 99) {
            displayLimitBorrowedBooks();
        } else if (bookAmount == 99) {
            patronsMenu();
        }

        String[][] borrowedBooks = new String[4][];

        // Define column length for borrowedBooks
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (i == 0) {
                borrowedBooks[i] = new String[2];
            } else {
                borrowedBooks[i] = new String[3];
            }
        }

        for (int i = 1; i <= bookAmount; i++) {
            System.out.printf(" - BOOK NAME (%d)           : ", i);
            borrowedBooks[i][0] = scan1.nextLine();
            System.out.printf(" - BOOK CODE (%d)           : ", i); 
            borrowedBooks[i][1] = Integer.toString(scan1.nextInt());
            scan1.nextLine();
        }

        System.out.print(" - ID CARD NUMBER          : ");
        borrowedBooks[0][0] = Integer.toString(scan1.nextInt());
        scan1.nextLine();

        // Convert borrowedBooks to two dimensional ArrayList
        ArrayList<ArrayList<String>> newBorrowedBooks = new ArrayList<>();
        for (String[] array : borrowedBooks) {
            ArrayList<String> innerList = new ArrayList<>();
            for (String element : array) {
                innerList.add(element);
            }
            newBorrowedBooks.add(innerList);
        }

        // Add new borrowed book to the main database
        main.borrowedBooksDatabase.add(newBorrowedBooks);

        main.loadingLine();
        System.out.println("\nSUCCESS!");

        main.enterForContinue();
        patronsMenu();
    }

    private static void displayLimitBorrowedBooks() {
        main.clearScreen();
        System.out.println(
            "=====================================\n" +
            "SORRY, YOU CAN'T BORROW MORE THAN 3 BOOKS!\n" +
            "====================================="
        );
        main.enterForContinue();
        borrowBooksMenu();
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
