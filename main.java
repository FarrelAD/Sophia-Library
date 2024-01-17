import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    static Scanner scan1 = new Scanner(System.in);

    static ArrayList<ArrayList<ArrayList<String>>> allUserData = new ArrayList<>();
    static ArrayList<ArrayList<String>> adminsData = new ArrayList<>();
    static ArrayList<ArrayList<String>> librariansData = new ArrayList<>();
    static ArrayList<ArrayList<String>> patronsData = new ArrayList<>();

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
    public static void main(String[] args) {
        loadData();
        login();
    }

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

    private static void login() {
        System.out.println("WELCOME! LOGIN FIRST!");
        System.out.print("-- USERNAME : ");
        username = scan1.nextLine();
        System.out.print("-- PASSWORD : ");
        password = scan1.nextInt();

        for (int i = 0; i < allUserData.size(); i++) {
            allUserData.get(i);
            ArrayList<ArrayList<String>> eachUserData = allUserData.get(i);
            for (int j = 0; j < eachUserData.size(); j++) {
                if ((username.toUpperCase()).equals(eachUserData.get(j).get(0))) {
                    System.out.println("YOU'RE GOOD BRO!");
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

        if (userType.equals("ADMIN")) {
            System.out.println("THIS IS ADMIN MENU");
            System.out.println(
                "   1. LIBRARIAN SETTINGS\n"+
                "   2. CHECK SYSTEM");
        } else if (userType.equals("LIBRARIAN")) {
            System.out.println("THIS IS LIBRARIAN MENU");
        } else if (userType.equals("PATRON")) {
            System.out.println("THIS IS PATRON MENU");
        } else {
            System.out.println("!!! INPUT INVALID !!!");
        }

    }
}
