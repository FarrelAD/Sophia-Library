package code;

import java.util.Scanner;

public class librarian {
    static Scanner scan1 = main.scan1;
    static int userInputMenu = main.userInputMenu;

    static String username = main.username;

    //------------------ MAIN MENU ------------------//
    public static void librariansMenu() {
        main.clearScreen();

        System.out.print(
            "-- LIBRARIAN MENU --\n" + 
            "   1. MANAGE LIBRARY COLLECTIONS\n" + 
            "   2. MANAGE PATRONS\n" +
            "   3. BROADCAST\n" +
            "   99. BACK\n" +
            "   00. EXIT\n" +
            "INPUT MENU -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();

        if (userInputMenu == 1) {
            manageLibraryCollectionsMenu();
        } else if (userInputMenu == 2) {
            managePatronsMenu();
        } else if (userInputMenu == 3) {
            sendBroadcast();
        } else if (userInputMenu == 99) {
            main.login();
        } else if (userInputMenu == 00) {
            main.exit();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void manageLibraryCollectionsMenu() {
        main.clearScreen();

        System.out.print(
            "-- MANAGE LIBRARY COLLECTIONS MENU --\n" + 
            "   1. ADD COLLECTIONS\n" + 
            "   2. SEARCH COLLECTIONS\n" + 
            "   99. BACK\n" +
            "INPUT MENU -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();

        if (userInputMenu == 1) {
            addCollectionsMenu();
        } else if (userInputMenu == 2) {
            searchCollectionsMenu();
        } else if (userInputMenu == 99) {
            librariansMenu();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void addCollectionsMenu() {
        main.clearScreen();

        System.out.print(
            "-- ADD LIBRARY COLLECTIONS --\n" +
            "   1. BOOKS\n" + 
            "   2. RESEARCH JOURNALS\n" +
            "   3. HERITAGE ITEMS\n" +
            "   4. NEWSPAPERS\n" +
            "   5. MAGAZINES\n" +
            "   6. ARTWORKS\n" +
            "   7. OTHER ITEMS\n" +
            "   99. BACK\n" +
            "INPUT MENU -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();

        if (userInputMenu == 1) {
            addBooks();
        } else if (userInputMenu == 2) {
            addResearchJournals();
        } else if (userInputMenu == 3) {
            addHeritageItems();
        } else if (userInputMenu == 4) {
            addNewspapers();
        } else if (userInputMenu == 5) {
            addMagazines();
        } else if (userInputMenu == 6) {
            addArtworks();
        } else if (userInputMenu == 7) {
            addOtherItems();
        } else if (userInputMenu == 99) {
            manageLibraryCollectionsMenu();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void addBooks() {
        main.clearScreen();

        String [] newBook = new String[7];
        System.out.println("ADD BOOKS HERE!");
        System.out.print(" - TITLE            : ");
        newBook[1] = scan1.nextLine();
        System.out.print(" - AUTHOR           : ");
        newBook[2] = scan1.nextLine();
        System.out.print(" - PUBLISHER        : ");
        newBook[3] = scan1.nextLine();
        System.out.print(" - PUBLICATION YEAR : ");
        newBook[4] = scan1.nextLine();
        System.out.print(" - ISBN             : ");
        newBook[5] = scan1.nextLine();
        System.out.print(" - SOURCE           : ");
        newBook[6] = scan1.nextLine();
        System.out.print(" - BOOK ID          : ");
        newBook[0] = scan1.nextLine();
        System.out.print(
            "=====================================\n" +
            "CONFIRMATION [1/0] -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();

        // Convert array into a String
        String sqlQueryAddData = String.format("INSERT INTO sophia_books VALUES ('%s', '%s', '%s', '%s', %s, %s, '%s')", newBook[0], newBook[1], newBook[2], newBook[3], newBook[4], newBook[5], newBook[6]);

        // For monitoring - QUERY [!]
        // System.out.println("Query: " + sqlQueryAddData);

        if (userInputMenu == 1) {
            newBookToDatabase(sqlQueryAddData);
        } else if (userInputMenu == 0) {
            newBookCancelled();
        } else {
            main.displayInvalidInput();
        }

        // For monitoring [!]
        // for (String myString : newBook) {
        //     System.out.println(myString);
        // }
    }

    private static void newBookToDatabase(String sqlQuery) {
        // main.booksDatabase.add(new ArrayList<>(Arrays.asList(newDataBook)));

        // For monitoring [!]
        // booksDatabase.forEach((n) -> System.out.println(n));

        // Add new book data with MySQL
        data.addToDatabase(sqlQuery);
    }

    private static void newBookCancelled() {
        main.clearScreen();

        System.out.println("ADDING BOOK IS CANCELLED");
        main.enterForContinue();
        main.generalMenu();
    }

    private static void addResearchJournals() {

    }

    private static void addHeritageItems() {

    }

    private static void addNewspapers() {

    }

    private static void addMagazines() {

    }

    private static void addArtworks() {

    }

    private static void addOtherItems() {

    }

    private static void searchCollectionsMenu() {
        main.clearScreen();
        System.out.print(
            "-- SEARCH LIBRARY COLLECTIONS --\n" +
            "   1. BOOKS\n" + 
            "   2. RESEARCH JOURNALS\n" +
            "   3. HERITAGE ITEMS\n" +
            "   4. NEWSPAPERS\n" +
            "   5. MAGAZINES\n" +
            "   6. ARTWORKS\n" +
            "   7. OTHER ITEMS\n" +
            "   99. BACK\n" +
            "INPUT MENU -> "
        );
        userInputMenu = scan1.nextInt();

        if (userInputMenu == 1) {
            searchBooks();
        } else if (userInputMenu == 2) {
            searchResearchJournals();
        } else if (userInputMenu == 3) {
            searchHeritageItems();
        } else if (userInputMenu == 4) {
            searchNewspapers();
        } else if (userInputMenu == 5) {
            searchMagazines();
        } else if (userInputMenu == 6) {
            searchArtworks();
        } else if (userInputMenu == 7) {
            searchOtherItems();
        } else if (userInputMenu == 99) {
            manageLibraryCollectionsMenu();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void searchBooks() {

    }

    private static void searchResearchJournals() {

    }

    private static void searchHeritageItems() {

    }

    private static void searchNewspapers() {

    }

    private static void searchMagazines() {

    }

    private static void searchArtworks() {

    }

    private static void searchOtherItems() {

    }

    private static void managePatronsMenu() {
        main.clearScreen();
        System.out.print(
            "-- MANAGE PATRONS MENU --\n" +
            "   1. VIEW BORROWER\n" +
            "   99. BACK\n" +
            "INPUT MENU -> " 
        );
        userInputMenu = scan1.nextInt();

        if (userInputMenu == 1) {
            viewBorrower();
        } else if (userInputMenu == 99) {
            librariansMenu();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void viewBorrower() {
        main.clearScreen();
        System.out.println(
            "ALL BORROWER IN LIBRARY '(NAME)'"
        );
    }

    private static void sendBroadcast() {
        main.clearScreen();
        System.out.print(
            "SEND BROADCAST!\n" +
            "   1. IN LIBRARY\n" +
            "   2. TO PATRONS\n"+
            "   99. BACK\n" +
            "INPUT MENU -> "
        );

        userInputMenu = scan1.nextInt();
        scan1.nextLine();

        if (userInputMenu == 1) {
            broadcastInLibrary();
        } else if (userInputMenu == 2) {
            broadcastToPatrons();
        } else if (userInputMenu == 99) {
            librariansMenu();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void broadcastInLibrary() {
        main.clearScreen();

        System.out.print(
            "= LIBRARY =\n" +
            "----------------------------------------------\n" +
            "TYPE THE MESSAGE\n"  +
            "> "
        );

        StringBuilder multipleLineMessage = new StringBuilder();
        String broadcastMessageLibrary;

        while (!(broadcastMessageLibrary = scan1.nextLine()).equalsIgnoreCase("exit")) {
            System.out.print("> ");
            multipleLineMessage.append("> " + broadcastMessageLibrary + "\n");
        }

        System.out.println("");
        main.loadingLine();

        System.out.print(
            "\n" +
            " From: " + username.toUpperCase() + " (Librarian)\n" +
            " To: Library visitors\n" +
            "\n" +
            " " + main.getCurrentDate() + "\n" +
            " " + main.getCurrentTime() + "\n" +
            "\n" +
            multipleLineMessage.toString() + "\n" +
            "===============================================\n" +
            "\n" +
            "BACK <99> >>> "
        );

        userInputMenu = scan1.nextInt();

        if (userInputMenu == 99) {
            sendBroadcast();
        } else {
            main.displayInvalidInput();
        }
    }
    
    private static void broadcastToPatrons() {
        main.clearScreen();

        System.out.print(
            "= PATRONS =\n" +
            "   1. ALL PATRONS\n" +
            "   2. SPECIFIC PATRONS\n" +
            "   99. BACK\n" +
            "INPUT MENU -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();

        if (userInputMenu == 1) {
            broadcastToAllPatrons();
        } else if (userInputMenu == 2) {
            broadcastToSpecificPatrons();
        } else if (userInputMenu == 99) {
            sendBroadcast();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void broadcastToAllPatrons() {
        main.clearScreen();

        System.out.print(
            "= ALL PATRONS =\n" +
            "----------------------------------------------\n" +
            "TYPE THE MESSAGE\n"  +
            "> "
        );

        StringBuilder multipleLineMessage = new StringBuilder();
        String broadcastMessageAllPatrons;

        while (!(broadcastMessageAllPatrons = scan1.nextLine()).equalsIgnoreCase("exit")) {
            System.out.print("> ");
            multipleLineMessage.append("> " + broadcastMessageAllPatrons + "\n");
        }

        System.out.println("");
        main.loadingLine();
        
        System.out.print(
            "\n" +
            " From: " + username.toUpperCase() + " (Librarian)\n" +
            " To: All patrons\n" +
            "\n" +
            " " + main.getCurrentDate() + "\n" +
            " " + main.getCurrentTime() + "\n" +
            "\n" +
            multipleLineMessage.toString() + "\n" +
            "===============================================\n" +
            "\n" +
            "BACK <99> >>> "
        );

        userInputMenu = scan1.nextInt();

        if (userInputMenu == 99) {
            sendBroadcast();
        } else {
            main.displayInvalidInput();
        }
    }

    private static void broadcastToSpecificPatrons() {
        main.clearScreen();

        System.out.print(
            "= SPECIFIC PATRON =\n" +
            "----------------------------------------------\n" +
            "TO : "
        );
        String patronName = scan1.nextLine();

        boolean isPatronNameValid = false;
        for (int i = 0; i < main.allUserData.get(2).size(); i++) {
            if (patronName.equalsIgnoreCase(main.allUserData.get(2).get(i).get(0))) {
                isPatronNameValid = true;
            }
        }

        if (isPatronNameValid) {
            System.out.print(
                "TYPE THE MESSAGE\n" +
                "> "
            );

            StringBuilder multipleLineMessage = new StringBuilder();
            String broadcastMessageSpecificPatron;

            while (!(broadcastMessageSpecificPatron = scan1.nextLine()).equalsIgnoreCase("exit")) {
                System.out.print("> ");
                multipleLineMessage.append("> " + broadcastMessageSpecificPatron + "\n");
            }

            System.out.println("");
            main.loadingLine();

            System.out.print(
                "\n" +
                " From: " + username.toUpperCase() + " (Librarian)\n" +
                " To: " + patronName.toUpperCase() + "\n" +
                "\n" +
                " " + main.getCurrentDate() + "\n" +
                " " + main.getCurrentTime() + "\n" +
                "\n" +
                multipleLineMessage.toString() + "\n" +
                "===============================================\n" +
                "\n" +
                "BACK <99> >>> "
            );

            userInputMenu = scan1.nextInt();

            if (userInputMenu == 99) {
                sendBroadcast();
            } else {
                main.displayInvalidInput();
            }
        } else {
            main.displayInvalidInput();
            broadcastToSpecificPatrons();
        }
    }
}
