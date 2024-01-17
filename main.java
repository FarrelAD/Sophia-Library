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

        // for (int i = 0; i < adminDataYes.length; i++) {
        //     allUserData.add(new ArrayList<>(List.of(adminDataYes[i])));
        // }

        // allUserData.forEach((n) -> System.out.println(n)); 

        System.out.println("WELCOME! LOGIN FIRST!");
        System.out.print("-- USERNAME : ");
        username = scan1.nextLine();
        System.out.print("-- PASSWORD : ");
        password = scan1.nextInt();
        
        for (int i = 0; i < allUserData.size(); i++) {
            
        }

        if ((username.toUpperCase()).equals("ADMIN")) {
            System.out.println("THIS IS ADMIN MENU");
            System.out.println(
                "   1. LIBRARIAN SETTINGS\n"+
                "   2. CHECK SYSTEM");
        } else if ((username.toUpperCase()).equals("LIBRARIAN")) {
            System.out.println("THIS IS LIBRARIAN MENU");
        } else if ((username.toUpperCase()).equals("PATRON")) {
            System.out.println("THIS IS PATRON MENU");
        } else {
            System.out.println("!!! INPUT INVALID !!!");
        }


        // Checking the username to the real data
        for (int i = 0; i < adminsData.size(); i++) {
            if (username.equals(adminsData.get(i).get(0))) {
                System.out.println("HEY BRO!");
            }
        }

    }
}
