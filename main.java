import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
    static Scanner scan1 = new Scanner(System.in);
    static Scanner scan2 = new Scanner(System.in);

    static ArrayList<ArrayList<ArrayList<String>>> allUserData = new ArrayList<>();
    static ArrayList<ArrayList<String>> adminsData = new ArrayList<>();
    static ArrayList<ArrayList<String>> librariansData = new ArrayList<>();
    static ArrayList<ArrayList<String>> patronsData = new ArrayList<>();
    
    static ArrayList<ArrayList<ArrayList<String>>> libraryCollections = new ArrayList<>();
    static ArrayList<ArrayList<String>> booksDatabase = new ArrayList<>();


    static String [][] adminsDataFirst = { 
        {"BUDI", "1234"},
        {"BADAK", "5678"},
        {"BADU", "9999"}
    };

    static String [][] librariansDataFirst = {
        {"NANA", "1122"},
        {"MAWAR", "4321"},
        {"ADI", "9090"},
        {"BEJO", "0101"}
    };

    static String [][] patronsDataFirst = {
        {"ANGGI", "5566"},
        {"SETIAWAN", "2332"},
        {"ALEXANDER", "9898"}
    };

    static String username;
    static int password;

    static String userType;
    static int userIndexArray;

    static int userInputMenu;


    //////////////// PRIMARY METHODS ////////////////
    private static void loadData() {
        for (int i = 0; i < adminsDataFirst.length; i++) {
            adminsData.add(new ArrayList<>());

            adminsData.get(i).add(adminsDataFirst[i][0]);
            adminsData.get(i).add(adminsDataFirst[i][1]);
        }
        
        // adminsData.forEach((n) -> System.out.println(n));

        for (int i = 0; i < librariansDataFirst.length; i++) {
            librariansData.add(new ArrayList<>());

            librariansData.get(i).add(librariansDataFirst[i][0]);
            librariansData.get(i).add(librariansDataFirst[i][1]);
        }

        // librariansData.forEach((n) -> System.out.println(n));

        for (int i = 0; i < patronsDataFirst.length; i++) {
            patronsData.add(new ArrayList<>());

            patronsData.get(i).add(patronsDataFirst[i][0]);
            patronsData.get(i).add(patronsDataFirst[i][1]);
        }

        // patronsData.forEach((n) -> System.out.println(n));

        int maxLengthArray = Math.max(adminsData.size(), Math.max(librariansData.size(), patronsData.size()));
        for (int i = 0; i < maxLengthArray; i++) {
            if (i == 0) {
                allUserData.add(adminsData);
            } else if (i == 1) {
                allUserData.add(librariansData);
            } else if (i == 2) {
                allUserData.add(patronsData);
            }
        }

        // allUserData.forEach((n) -> System.out.println(n));
    }

    //////////////// PRIMARY METHODS ////////////////
    private static void login() {
        clearScreen();

        System.out.println("WELCOME! LOGIN FIRST!");
        System.out.print("-- USERNAME : ");
        username = scan2.nextLine();
        System.out.print("-- PASSWORD : ");
        password = scan1.nextInt();

        for (int i = 0; i < allUserData.size(); i++) {
            allUserData.get(i);
            ArrayList<ArrayList<String>> eachUserData = allUserData.get(i);
            for (int j = 0; j < eachUserData.size(); j++) {
                if ((username.toUpperCase()).equals(eachUserData.get(j).get(0))) {
                    userType = Integer.toString(i);
                    userIndexArray = j;
                }
            }
        }

        // System.out.println("DATA CHECKING -> \n" +
        // "-- userType : " + userType + "\n" +
        // "-- userIndexArray : " + userIndexArray + "\n");

        if (userType.equals("0") ) {
            userType = "ADMIN";
        } else if (userType.equals("1")) {
            userType = "LIBRARIAN";
        } else if (userType.equals("2")) {
            userType = "PATRON";
        } else {
            userType = "WRONG ACCOUNT";
        }

        generalMenu();
    }

    //////////////// PRIMARY METHODS ////////////////
    private static void generalMenu() {
        clearScreen();

        if (userType.equals("ADMIN")) {
            adminsMenu();
        } else if (userType.equals("LIBRARIAN")) {
            librariansMenu();
        } else if (userType.equals("PATRON")) {
            patronsMenu();
        } else {
            displayInvalidInput();
        }
    }


    ///////////////////////////////////////////////////


    ////////////////////// ADMIN //////////////////////
    //------------------ MAIN MENU ------------------//
    private static void adminsMenu() {
        clearScreen();

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





    ////////////////////// LIBRAIAN //////////////////////
    //------------------ MAIN MENU ------------------//
    private static void librariansMenu() {
        clearScreen();

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
            login();
        } else if (userInputMenu == 00) {
            exit();
        } else {
            displayInvalidInput();
        }
    }

    private static void manageLibraryCollectionsMenu() {
        clearScreen();

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
            displayInvalidInput();
        }
    }

    private static void addCollectionsMenu() {
        clearScreen();

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
            displayInvalidInput();
        }
    }

    private static void addBooks() {
        clearScreen();

        String [] newBook = new String[6];
        System.out.println("ADD BOOKS HERE!");
        System.out.print(" - TITLE            : ");
        newBook[0] = scan1.nextLine();
        System.out.print(" - AUTHOR           : ");
        newBook[1] = scan1.nextLine();
        System.out.print(" - PUBLISHER        : ");
        newBook[2] = scan1.nextLine();
        System.out.print(" - PUBLICATION YEAR : ");
        newBook[3] = scan1.nextLine();
        System.out.print(" - ISBN             : ");
        newBook[4] = scan1.nextLine();
        System.out.print(" - SOURCE           : ");
        newBook[5] = scan1.nextLine();
        System.out.print(
            "=====================================\n" +
            "CONFIRMATION [1/0] -> "
        );
        userInputMenu = scan1.nextInt();
        scan1.nextLine();

        if (userInputMenu == 1) {
            newBookToDatabase(newBook);
        } else if (userInputMenu == 0) {
            newBookCancelled();
        } else {
            displayInvalidInput();
        }

        // For monitoring [!]
        // for (String myString : newBook) {
        //     System.out.println(myString);
        // }
    }

    private static void newBookToDatabase(String[] newDataBook) {
        booksDatabase.add(new ArrayList<>(Arrays.asList(newDataBook)));

        // For monitoring [!]
        // booksDatabase.forEach((n) -> System.out.println(n));
    }

    private static void newBookCancelled() {
        clearScreen();

        System.out.println("ADDING BOOK IS CANCELLED");
        enterForContinue();
        generalMenu();
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
        clearScreen();
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
            displayInvalidInput();
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
        clearScreen();
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
            displayInvalidInput();
        }
    }

    private static void viewBorrower() {
        clearScreen();
        System.out.println(
            "ALL BORROWER IN LIBRARY '(NAME)'"
        );
    }

    private static void sendBroadcast() {
        clearScreen();
        System.out.println(
            "SEND BROADCAST TO PATRONS!"
        );
    }





    ////////////////////// PATRONS //////////////////////
    //------------------- MAIN MENU -------------------//
    private static void patronsMenu() {
        clearScreen();
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
    }


    ///////////////////////////////////////////////////


    ///////////////// USEFUL METHODS /////////////////
    private static void displayInvalidInput() {
        clearScreen();

        System.out.println("!!! INPUT INVALID !!!");

        enterForContinue();
    }

    private static void exit() {
        clearScreen();

        System.out.println("! YOU'RE EXIT THE PROGRAM !");
    }

    private static void enterForContinue() {
        System.out.print("ENTER FOR CONTINUE -> ");
        String myEnter = scan1.nextLine();
    }

    private static void clearScreen() {
        System.out.println("\033[H\033[2J");
		System.out.flush();
    }



    public static void main(String[] args) {
        loadData();
        login();
    }
}
