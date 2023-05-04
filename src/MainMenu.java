import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
Methods methods = new Methods();
    public void userMenu() {

        Scanner userScanner = new Scanner(System.in);


        boolean keepRunning = true;

        do {
            System.out.println("1.add contact.");
            System.out.println("2. Delete contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Show all Contacts");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4 or 5)");
            int UserInput = userScanner.nextInt();

//            Adds a contact
            switch (UserInput) {
                case 1:
                    methods.addContact();
                    System.out.println("add contact");

                    break;

                case 2:
                    methods.deleteContact();
                    System.out.println("Delete contact");

                    break;

                case 3:
                    methods.searchForContact();
                    userMenu();

                    break;

                case 4:
                    //Shows all contacts
                    methods.showAllContacts();
                    System.out.println("Show all contacts");
                    break;

                case 5:
                    if (UserInput == 5) {
                        keepRunning = false;
                    }
                    System.out.println("Exit");
                    break;
            }

        } while (keepRunning);
    }
}
