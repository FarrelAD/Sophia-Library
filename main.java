import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    static Scanner scan1 = new Scanner(System.in);

    static ArrayList<ArrayList<ArrayList<String>>> allUserData = new ArrayList<>();
    static ArrayList<ArrayList<String>> adminData = new ArrayList<>();

    static String [][] adminDataYes = { 
        {"BUDI", "1234"},
        {"BADAK", "5678"},
        {"BADU", "9999"}
    };

    static String [][] librarianData = {
        {"NANA", "1122"},
        {"MAWAR", "4321"},
        {"ADI", "9090"}
    };

    static String [][] patronData = {
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
        for (int i = 0; i < 3; i++) {
            adminData.add(new ArrayList<>());
        }

        adminData.get(0).add("BUDI");
        adminData.get(0).add("BADAK");
        adminData.get(0).add("BADU");

        
    }

    private static void login() {

        // for (int i = 0; i < adminDataYes.length; i++) {
        //     allUserData.add(new ArrayList<>(List.of(adminDataYes[i])));
        // }

        allUserData.forEach((n) -> System.out.println(n)); 

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
    }
}
