import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
    public static Scanner scan1 = new Scanner(System.in);
    static Scanner scan2 = new Scanner(System.in);

    public static ArrayList<ArrayList<ArrayList<String>>> allUserData = new ArrayList<>();
    static ArrayList<ArrayList<String>> adminsData = new ArrayList<>();
    static ArrayList<ArrayList<String>> librariansData = new ArrayList<>();
    static ArrayList<ArrayList<String>> patronsData = new ArrayList<>();
    
    static ArrayList<ArrayList<ArrayList<String>>> libraryCollections = new ArrayList<>();
    public static ArrayList<ArrayList<String>> booksDatabase = new ArrayList<>();

    static LocalDateTime currentDateTime = LocalDateTime.now();


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

    public static String username;
    static int password;

    static String userType;
    static int userIndexArray;

    public static int userInputMenu;


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
    public static void login() {
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
    public static void generalMenu() {
        clearScreen();

        if (userType.equals("ADMIN")) {
            admin.adminsMenu();
        } else if (userType.equals("LIBRARIAN")) {
            librarian.librariansMenu();
        } else if (userType.equals("PATRON")) {
            patronsMenu();
        } else {
            displayInvalidInput();
        }
    }


    ///////////////////////////////////////////////////


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
    public static void displayInvalidInput() {
        clearScreen();

        System.out.println("!!! INPUT INVALID !!!");

        enterForContinue();
    }

    public static void exit() {
        clearScreen();

        System.out.println("! YOU'RE EXIT THE PROGRAM !");
    }

    public static void enterForContinue() {
        System.out.print("ENTER FOR CONTINUE -> ");
        String myEnter = scan1.nextLine();
    }

    public static void loadingLine() {
        String loadingText = "===============================================";
        for (char c : loadingText.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
		System.out.flush();
    }

    public static String getCurrentDate() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDateTime.format(dateFormatter);

        return formattedDate;
    }

    public static String getCurrentTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentDateTime.format(timeFormatter);

        return formattedTime;
    }



    public static void main(String[] args) {
        loadData();
        login();
    }
}
